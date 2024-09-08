package sazhin.pp.studentportalapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.MapObjectCollection
import com.yandex.mapkit.map.PlacemarkMapObject
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider
import sazhin.pp.studentportalapp.R
import sazhin.pp.studentportalapp.databinding.FragmentResumeAllBinding
import sazhin.pp.studentportalapp.databinding.FragmentSearchOneBinding

class SearchOneFragment : Fragment() {

    private lateinit var mapView: MapView
    private lateinit var imageProvider: ImageProvider

    private lateinit var binding: FragmentSearchOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        MapKitFactory.initialize(this.context)
        binding = FragmentSearchOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initMap()
        initBtNav()
    }

    private fun initBtNav() {
        binding.idButtonBuy.setOnClickListener {
            findNavController().navigate(R.id.action_searchOneFrag_to_educationAllFrag)
        }
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onStart() {
        mapView.onStart()
        MapKitFactory.getInstance().onStart()
        super.onStart()
    }

    private fun initMap() {
        mapView = binding.imCarteGeo
        imageProvider = ImageProvider.fromResource(this.context, R.drawable.icon_location_2)

        mapView.map.move(
            CameraPosition(Point(56.840823, 60.650763), 16.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 1f), null
        )

        val placemark: PlacemarkMapObject =
            mapView.map.mapObjects.addPlacemark(Point(56.840823, 60.650763), imageProvider)
    }
}