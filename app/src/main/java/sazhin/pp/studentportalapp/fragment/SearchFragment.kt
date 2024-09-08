package sazhin.pp.studentportalapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import sazhin.pp.studentportalapp.R
import sazhin.pp.studentportalapp.app.adapter.SearchAdapter
import sazhin.pp.studentportalapp.app.adapter.dto.SearchDto
import sazhin.pp.studentportalapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    private lateinit var adapter: SearchAdapter

    private var listCareer: MutableList<SearchDto> = mutableListOf(
        SearchDto("Back-разработчик на джаве", "30000 - 45000 руб", "ИРИТ-РТФ", "Без опыта", "Техническое образование"),
        SearchDto("Разработчик", "20000 - 25000 руб", "Наша Гордость", "Без опыта", "Техническое образование"),
        SearchDto("Developer", "20000 - 25000 руб", "Знай наших", "Без опыта", "Техническое образование")
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
        initBtNav()

        adapter.submitList(listCareer)
    }

    private fun initBtNav() {
        binding.ArrowLeft.setOnClickListener {
            findNavController().navigate(R.id.action_searchAllFrag_to_resumeAllFrag)
        }
    }

    private fun initRcView() {
        adapter = SearchAdapter()
        adapter.setOnButtonClickListener(object : SearchAdapter.OnButtonClickListener {
            override fun onClick() {
                findNavController().navigate(R.id.action_searchAllFrag_to_searchOneFrag)
            }
        })
        binding.idListCar.layoutManager = LinearLayoutManager(context)
        binding.idListCar.adapter = adapter
    }
}