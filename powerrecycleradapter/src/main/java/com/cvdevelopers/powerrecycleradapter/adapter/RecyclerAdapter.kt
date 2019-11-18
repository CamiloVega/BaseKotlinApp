package com.cvdevelopers.powerrecycleradapter.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup

class RecyclerAdapter(private val dataSource: RecyclerDataSource): RecyclerView.Adapter<RecyclerViewHolder>() {

    var selectedPosition = RecyclerView.NO_POSITION
    set(value) {
        notifyItemChanged(field)
        field = value
        notifyItemChanged(field)
    }

    init {
        dataSource.attachAdapter(this)
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder =
        RecyclerViewHolder(parent, dataSource.rendererForViewType(viewType))

    override fun getItemCount(): Int =
        dataSource.getCount()

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(dataSource.getItem(position))
        holder.setSelected(selectedPosition == position)
    }

    override fun getItemId(position: Int): Long =
        dataSource.getItem(position).getId()

    override fun getItemViewType(position: Int): Int =
            dataSource.getLayoutResourceForPosition(position) ?: -1

}