package com.cvdevelopers.powerrecycleradapter.adapter

import androidx.recyclerview.widget.DiffUtil
import com.cvdevelopers.powerrecycleradapter.item.RecyclerItem

class RecyclerDiffCallback(
    private val oldItems: List<out RecyclerItem>,
    private val newItems: List<out RecyclerItem>
): DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition].getId() == newItems[newItemPosition].getId()

    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition].getItemsHash() == newItems[newItemPosition].getItemsHash()
}