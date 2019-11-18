package com.cvdevelopers.powerrecycleradapter.item

interface RecyclerItem {
    fun getId(): Long
    fun getRendererKey(): String
    fun getItemsHash(): Int
}