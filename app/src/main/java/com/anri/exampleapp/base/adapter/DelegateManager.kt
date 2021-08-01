package com.anri.exampleapp.base.adapter

import androidx.collection.SparseArrayCompat
import com.anri.exampleapp.domain.model.PostModel

class DelegateManager{

    private var delegates: SparseArrayCompat<AdapterDelegate> = SparseArrayCompat()

    fun addDelegate(delegate: AdapterDelegate) = delegates.put(delegates.size(), delegate)

    fun getDelegate(viewType: Int): AdapterDelegate = delegates[viewType]!!

    fun getItemViewType(postModel: PostModel): Int{
        for (i in 0 until delegates.size()){
            delegates[i]?.let {
                if (it.isValidType(postModel)) {
                    return delegates.keyAt(i)
                }
            }
        }

        throw NullPointerException("Delegate not found for $postModel")
    }
}