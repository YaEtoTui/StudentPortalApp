package sazhin.pp.studentportalapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sazhin.pp.studentportalapp.R
import sazhin.pp.studentportalapp.databinding.FragmentResumeAllBinding
import sazhin.pp.studentportalapp.databinding.FragmentResumeOneBinding

class ResumeOneFragment : Fragment() {

    private lateinit var binding: FragmentResumeOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResumeOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBtNav()
    }

    private fun initBtNav() {
        binding.idBack.setOnClickListener {
            findNavController().navigate(R.id.action_resumeOneFrag_to_resumeAllFrag)
        }
        binding.ArrowRight.setOnClickListener {
            findNavController().navigate(R.id.action_resumeOneFrag_to_searchAllFrag)
        }
    }
}