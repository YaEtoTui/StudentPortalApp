package sazhin.pp.studentportalapp.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.RadioGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.slots.PredefinedSlots
import ru.tinkoff.decoro.watchers.FormatWatcher
import ru.tinkoff.decoro.watchers.MaskFormatWatcher
import sazhin.pp.studentportalapp.R
import sazhin.pp.studentportalapp.app.adapter.FilterAdapter
import sazhin.pp.studentportalapp.databinding.FragmentEntryBinding
import sazhin.pp.studentportalapp.databinding.FragmentRegistrationBinding
import sazhin.pp.studentportalapp.databinding.FragmentResumeAllBinding

class RegistrationFragment : Fragment() {

    private lateinit var adapter: FilterAdapter

    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //маска для ввода телефона
        val mask = MaskImpl.createTerminated(PredefinedSlots.RUS_PHONE_NUMBER)
        mask.isForbidInputWhenFilled = false // default value

        val formatWatcher: FormatWatcher = MaskFormatWatcher(mask)
        formatWatcher.installOn(binding.edPhone)

        initListGender()
        initBtNav()
        initCalendar()
    }

    private fun initCalendar() {

        binding.apply {

            edDate.setOnClickListener {
                if (Calendar.isVisible) {
                    Calendar.visibility = View.GONE
                } else {
                    Calendar.visibility = View.VISIBLE
                }
            }

            calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
                edDate.setText("$dayOfMonth.${month + 1}.$year")
                Calendar.visibility = View.GONE
            }
        }
    }

    private fun initListGender() {
        adapter = FilterAdapter()
        adapter.setOnButtonClickListener(object : FilterAdapter.OnButtonClickListener {
            override fun onClick(strChoice: String) {
                binding.edGender.setText(strChoice)
                binding.idListGenders.visibility = View.GONE
            }
        })
        binding.idListGenders.layoutManager = LinearLayoutManager(context)
        binding.idListGenders.adapter = adapter

        val listString: List<String> = listOf("Мужчина", "Женщина")

        adapter.submitList(listString)

        binding.edGender.setOnClickListener {
            if (binding.idListGenders.isVisible)
                binding.idListGenders.visibility = View.GONE
            else
                binding.idListGenders.visibility = View.VISIBLE
        }
    }

    private fun initBtNav() {
        binding.idButtonRegistration.setOnClickListener {
            findNavController().navigate(R.id.action_regFrag_to_entryFrag)
        }
    }
}