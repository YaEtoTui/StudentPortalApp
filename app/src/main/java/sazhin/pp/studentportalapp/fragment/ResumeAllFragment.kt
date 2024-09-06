package sazhin.pp.studentportalapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import sazhin.pp.studentportalapp.R
import sazhin.pp.studentportalapp.app.adapter.ResumeAdapter
import sazhin.pp.studentportalapp.app.adapter.dto.ResumeDto
import sazhin.pp.studentportalapp.databinding.FragmentEntryBinding
import sazhin.pp.studentportalapp.databinding.FragmentResumeAllBinding
import java.util.Collections

class ResumeAllFragment : Fragment() {

    private lateinit var binding: FragmentResumeAllBinding

    private lateinit var adapter: ResumeAdapter

    private var listResume: MutableList<ResumeDto> = mutableListOf(
        ResumeDto("", ""),
        ResumeDto("", ""),
        ResumeDto("", ""),
        ResumeDto("", ""),
        ResumeDto("", ""),
        ResumeDto("", ""),
        ResumeDto("", ""),
        ResumeDto("", "")
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

        adapter.submitList(listResume)
    }

    private fun initRcView() {
        adapter = ResumeAdapter()
        binding.idListResume.layoutManager = LinearLayoutManager(context)
        binding.idListResume.adapter = adapter
    }
}