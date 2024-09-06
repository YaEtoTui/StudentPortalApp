package sazhin.pp.studentportalapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sazhin.pp.studentportalapp.R
import sazhin.pp.studentportalapp.databinding.FragmentEntryBinding

class EntryFragment : Fragment() {

    private lateinit var binding: FragmentEntryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEntryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBtNav()
    }

    private fun initBtNav() {
        binding.Registr.setOnClickListener {
            findNavController().navigate(R.id.action_entryFrag_to_regFrag)
        }
        binding.idButtonAuth.setOnClickListener {
            findNavController().navigate(R.id.action_entryFrag_to_resumeAllFrag)
        }
    }
}