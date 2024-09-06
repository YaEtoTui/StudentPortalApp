package sazhin.pp.studentportalapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sazhin.pp.studentportalapp.R
import sazhin.pp.studentportalapp.databinding.FragmentEntryBinding
import sazhin.pp.studentportalapp.databinding.FragmentRegistrationBinding
import sazhin.pp.studentportalapp.databinding.FragmentResumeAllBinding

class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }
}