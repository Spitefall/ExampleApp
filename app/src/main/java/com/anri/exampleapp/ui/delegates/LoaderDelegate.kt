package com.anri.exampleapp.ui.delegates

import android.view.ViewGroup
import com.anri.exampleapp.R
import com.anri.exampleapp.base.adapter.AdapterDelegate
import com.anri.exampleapp.base.adapter.BaseViewHolder
import com.anri.exampleapp.domain.model.PostModel
import com.anri.exampleapp.ui.model.Loader

class LoaderViewHolder(val parent: ViewGroup) : BaseViewHolder(parent, R.layout.item_loader) {

    override fun bind(model: PostModel, viewHolder: BaseViewHolder) {}
}

class LoaderDelegate : AdapterDelegate {

    override fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder =
        LoaderViewHolder(parent)

    override fun isValidType(postModel: PostModel): Boolean = postModel is Loader
}

