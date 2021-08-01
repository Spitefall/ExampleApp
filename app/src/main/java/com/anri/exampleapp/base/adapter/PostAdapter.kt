package com.anri.exampleapp.base.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.anri.exampleapp.domain.model.PostModel

abstract class PostAdapter(
    delegates: List<AdapterDelegate>,
) : ListAdapter<PostModel, BaseViewHolder>(BaseDiffUtil()) {
    private val delegateManager = DelegateManager()

    init {
        delegates.forEach {
            delegateManager.addDelegate(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        delegateManager.getDelegate(viewType).onCreateViewHolder(parent)


    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int, payloads: MutableList<Any>) {
        if(payloads.isEmpty())
            super.onBindViewHolder(holder, position, payloads)
        else
            holder.bindPayload(getItem(position), holder, payloads[0] as MutableList<Any>)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int){
        holder.bind(getItem(position), holder)
    }

    override fun getItemViewType(position: Int): Int = delegateManager.getItemViewType(getItem(position))

    override fun submitList(list: List<PostModel>?) {
        synchronized(this) {
            super.submitList(list)
        }
    }

    fun submitItem(item: PostModel) {
        synchronized(this) {
            super.submitList(mutableListOf(item))
        }
    }

    fun isEmpty() = currentList.isEmpty()
}