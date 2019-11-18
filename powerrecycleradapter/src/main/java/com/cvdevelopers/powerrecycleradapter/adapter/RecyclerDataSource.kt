package com.cvdevelopers.powerrecycleradapter.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.annotation.LayoutRes
import com.cvdevelopers.powerrecycleradapter.item.ItemRenderer
import com.cvdevelopers.powerrecycleradapter.item.RecyclerItem
import java.lang.ref.WeakReference
import javax.inject.Inject

class RecyclerDataSource @Inject constructor(val renderers: Map<String, @JvmSuppressWildcards ItemRenderer<out RecyclerItem>>) {

    private var data = ArrayList<RecyclerItem>()
    var viewTypeToRendererKey: HashMap<Int, String> = HashMap()
    var adapter: WeakReference<RecyclerView.Adapter<out RecyclerView.ViewHolder>>? = null
    init {
        renderers.forEach {
            viewTypeToRendererKey[it.value.getLayoutId()] = it.key
        }
    }

    fun setData(newData: List<RecyclerItem>) {
        val diffCallback = DiffUtil.calculateDiff(RecyclerDiffCallback(data, newData))
        data.clear()
        data.addAll(newData)
        adapter?.get()?.let { diffCallback.dispatchUpdatesTo(it) }

    }

    @Suppress("UNCHECKED_CAST")
    fun rendererForViewType(viewType: Int): ItemRenderer<RecyclerItem> =
        renderers[viewTypeToRendererKey[viewType]] as ItemRenderer<RecyclerItem>

    @LayoutRes
    fun getLayoutResourceForPosition(position: Int):Int? =
        renderers[data[position].getRendererKey()]?.getLayoutId()

    fun getCount(): Int = data.size

    fun getItem(position: Int): RecyclerItem = data[position]

    fun attachAdapter(adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>) {
        this.adapter = WeakReference(adapter)
    }
}