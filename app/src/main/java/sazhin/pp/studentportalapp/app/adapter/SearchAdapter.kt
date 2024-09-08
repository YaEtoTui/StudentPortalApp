package sazhin.pp.studentportalapp.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sazhin.pp.studentportalapp.R
import sazhin.pp.studentportalapp.app.adapter.dto.SearchDto
import sazhin.pp.studentportalapp.databinding.ItemListSearchBinding

class SearchAdapter : ListAdapter<SearchDto, SearchAdapter.Holder>(Comparator()) {

    private lateinit var onButtonClickListener: OnButtonClickListener

    class Holder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemListSearchBinding.bind(view)

        fun bind(searchDto: SearchDto, onButtonClickListener: OnButtonClickListener) = with(binding) {

            Prof.text = searchDto.profession
            Sum.text = searchDto.sum
            Firma.text = searchDto.company
            Source.text = searchDto.experience
            Education.text = searchDto.educationType

            /* Написать */
            binding.idButtonClick.setOnClickListener {
                onButtonClickListener.onClick()
            }
        }
    }

    class Comparator : DiffUtil.ItemCallback<SearchDto>() {
        override fun areItemsTheSame(oldItem: SearchDto, newItem: SearchDto): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: SearchDto, newItem: SearchDto): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_search, parent, false)
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