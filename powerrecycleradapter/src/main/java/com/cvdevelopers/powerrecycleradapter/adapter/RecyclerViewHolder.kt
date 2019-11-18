package com.cvdevelopers.powerrecycleradapter.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.cvdevelopers.powerrecycleradapter.item.ItemRenderer
import com.cvdevelopers.powerrecycleradapter.item.RecyclerItem

class RecyclerViewHolder(view: ViewGroup, private val renderer: ItemRenderer<RecyclerItem>): RecyclerView.ViewHolder(renderer.createView(view)) {

    fun bind(item: RecyclerItem) =
        renderer.render(itemView, item)

    fun setSelected(isSelected: Boolean) {
        renderer.isSelected(isSelected, itemView)
    }

}