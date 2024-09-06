package sazhin.pp.studentportalapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import sazhin.pp.studentportalapp.app.adapter.SearchAdapter
import sazhin.pp.studentportalapp.app.adapter.dto.SearchDto
import sazhin.pp.studentportalapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    private lateinit var adapter: SearchAdapter

    private var listCareer: MutableList<SearchDto> = mutableListOf(
        SearchDto("", ""),
        SearchDto("", ""),
        SearchDto("", ""),
        SearchDto("", "")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRcView()
        adapter.submitList(listCareer)
    }

    private fun initRcView() {
        adapter = SearchAdapter()
        adapter.setOnButtonClickListener(object : SearchAdapter.OnButtonClickListener {
            override fun onClick() {
//                findNavController().navigate(R.id.action_educationAllFrag_to_educationOneFrag)
            }
        })
        binding.idListCar.layoutManager = LinearLayoutManager(context)
        binding.idListCar.adapter = adapter
    }
}