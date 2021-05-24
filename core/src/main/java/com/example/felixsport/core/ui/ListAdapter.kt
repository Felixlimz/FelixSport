package com.example.felixsport.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.felixsport.core.R
import com.example.felixsport.core.databinding.ItemListRecyclerBinding
import com.example.felixsport.core.domain.model.Sport
import java.util.ArrayList

class ListAdapter : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var list = ArrayList<Sport>()
    var onItemClick: ((Sport) -> Unit)? = null

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding = ItemListRecyclerBinding.bind(itemView)
        fun bind(item: Sport){
            with(binding){
                Glide.with(itemView.context)
                    .load(item.strThumb)
                    .into(tvImageItem)
                tvTitle.text = item.strSport
                tvSubtitle.text = item.strFormat
            }
        }
        init {
            binding.root.setOnClickListener{
                onItemClick?.invoke(list[adapterPosition])
            }

        }
    }

    fun setData(newList: List<Sport>?) {
        if (newList == null) return
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_recycler, parent, false))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = list[position]
        holder.bind(data)
    }
}