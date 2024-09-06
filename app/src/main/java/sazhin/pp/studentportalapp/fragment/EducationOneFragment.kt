package sazhin.pp.studentportalapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sazhin.pp.studentportalapp.R
import sazhin.pp.studentportalapp.databinding.FragmentEducationBinding
import sazhin.pp.studentportalapp.databinding.FragmentEducationOneBinding
import sazhin.pp.studentportalapp.databinding.FragmentResumeAllBinding

class EducationOneFragment : Fragment() {

    private lateinit var binding: FragmentEducationOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEducationOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBtNav()
    }

    private fun initBtNav() {
        binding.view3.setOnClickListener {
            findNavController().navigate(R.id.action_educationOneFrag_to_educationAllFrag)
        }
    }
}