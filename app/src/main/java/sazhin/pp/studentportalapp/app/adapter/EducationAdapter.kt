package sazhin.pp.studentportalapp.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sazhin.pp.studentportalapp.R
import sazhin.pp.studentportalapp.app.adapter.dto.EducationDto
import sazhin.pp.studentportalapp.app.adapter.dto.ResumeDto
import sazhin.pp.studentportalapp.databinding.ItemListEducationBinding
import sazhin.pp.studentportalapp.databinding.ItemListResumeBinding

class EducationAdapter : ListAdapter<EducationDto, EducationAdapter.Holder>(Comparator()) {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemListEducationBinding.bind(view)

        fun bind(educationDto: EducationDto) = with(binding) {

            if (educationDto.check) {
                binding.Check.visibility = View.VISIBLE
            }
        }
    }

    class Comparator : DiffUtil.ItemCallback<EducationDto>() {
        override fun areItemsTheSame(oldItem: EducationDto, newItem: EducationDto): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: EducationDto, newItem: EducationDto): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_education, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}