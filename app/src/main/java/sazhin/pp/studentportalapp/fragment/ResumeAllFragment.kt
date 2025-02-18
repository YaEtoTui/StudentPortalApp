package sazhin.pp.studentportalapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import sazhin.pp.studentportalapp.R
import sazhin.pp.studentportalapp.app.adapter.ResumeAdapter
import sazhin.pp.studentportalapp.app.adapter.dto.ResumeDto
import sazhin.pp.studentportalapp.databinding.FragmentResumeAllBinding

class ResumeAllFragment : Fragment() {

    private lateinit var binding: FragmentResumeAllBinding

    private lateinit var adapter: ResumeAdapter

    private var listResume: MutableList<ResumeDto> = mutableListOf(
        ResumeDto("Back-разработчик стажер", "08.09.2024"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResumeAllBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRcView()
        initBtNav()

        adapter.submitList(listResume)
    }

    private fun initBtNav() {
        binding.ArrowLeft.setOnClickListener {
            findNavController().navigate(R.id.action_resumeAllFrag_to_educationAllFrag)
        }
        binding.ArrowRight.setOnClickListener {
            findNavController().navigate(R.id.action_resumeAllFrag_to_searchAllFrag)
        }
    }

    private fun initRcView() {
        adapter = ResumeAdapter()
        adapter.setOnButtonClickListener(object : ResumeAdapter.OnButtonClickListener {
            override fun onClick() {
                findNavController().navigate(R.id.action_resumeAllFrag_to_resumeOneFrag)
            }
        })
        binding.idListResume.layoutManager = LinearLayoutManager(context)
        binding.idListResume.adapter = adapter
    }
}