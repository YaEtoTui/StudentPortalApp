package sazhin.pp.studentportalapp.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sazhin.pp.studentportalapp.R
import sazhin.pp.studentportalapp.app.adapter.dto.ResumeDto
import sazhin.pp.studentportalapp.databinding.ItemListResumeBinding

class ResumeAdapter : ListAdapter<ResumeDto, ResumeAdapter.Holder>(Comparator()) {

    private lateinit var onButtonClickListener: ResumeAdapter.OnButtonClickListener

    class Holder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemListResumeBinding.bind(view)

        fun bind(resumeDto: ResumeDto, onButtonClickListener: ResumeAdapter.OnButtonClickListener) = with(binding) {
            /* Написать */
            binding.cView.setOnClickListener {
                onButtonClickListener.onClick()
            }
        }
    }

    class Comparator : DiffUtil.ItemCallback<ResumeDto>() {
        override fun areItemsTheSame(oldItem: ResumeDto, newItem: ResumeDto): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ResumeDto, newItem: ResumeDto): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_resume, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position), onButtonClickListener)
    }

    interface OnButtonClickListener {
        fun onClick()
    }

    fun setOnButtonClickListener(listener: OnButtonClickListener) {
        onButtonClickListener = listener
    }
}