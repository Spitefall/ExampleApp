package com.anri.exampleapp.base.adapter

import android.view.ViewGroup
import com.anri.exampleapp.domain.model.PostModel

interface AdapterDelegate {

    fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder

    fun isValidType(postModel: PostModel): Boolean
}