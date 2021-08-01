package com.anri.exampleapp.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anri.exampleapp.domain.model.PostModel

abstract class BaseViewHolder : RecyclerView.ViewHolder{

    constructor(parent: ViewGroup, layoutId: Int) : super(LayoutInflater.from(parent.context).inflate(layoutId, parent, false))
    constructor(view: View) : super(view)

    open fun bind(model: PostModel, viewHolder: BaseViewHolder) {}
    open fun bindPayload(model : PostModel, viewHolder: BaseViewHolder, payloads : MutableList<Any>){}
}