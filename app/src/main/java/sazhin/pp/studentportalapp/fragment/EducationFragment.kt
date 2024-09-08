package sazhin.pp.studentportalapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import sazhin.pp.studentportalapp.R
import sazhin.pp.studentportalapp.app.adapter.EducationAdapter
import sazhin.pp.studentportalapp.app.adapter.ResumeAdapter
import sazhin.pp.studentportalapp.app.adapter.dto.EducationDto
import sazhin.pp.studentportalapp.app.adapter.dto.ResumeDto
import sazhin.pp.studentportalapp.databinding.FragmentEducationBinding
import sazhin.pp.studentportalapp.databinding.FragmentResumeAllBinding

class EducationFragment : Fragment() {

    private lateinit var binding: FragmentEducationBinding

    private lateinit var adapter: EducationAdapter

    private var listEducation: MutableList<EducationDto> = mutableListOf(
        EducationDto("Изучение Git", false, false),
        EducationDto("Релляционные БД", false, false),
        EducationDto("Промышленная разработка на Java", false, true),
        EducationDto("Алгоритмы и структуры данных", false, true)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEducationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRcView()
        initBtNav()

        adapter.submitList(listEducation)
    }
    private fun initBtNav() {
        binding.ArrowRight.setOnClickListener {
            findNavController().navigate(R.id.action_educationAllFrag_to_resumeAllFrag)
        }
    }

    private fun initRcView() {
        adapter = EducationAdapter()
        adapter.setOnButtonClickListener(object : EducationAdapter.OnButtonClickListener {
            override fun onClick() {
                findNavController().navigate(R.id.action_educationAllFrag_to_educationOneFrag)
            }
        })
        binding.idListEducation.layoutManager = LinearLayoutManager(context)
        binding.idListEducation.adapter = adapter
    }
}