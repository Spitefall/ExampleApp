package com.anri.exampleapp.base.adapter

import androidx.recyclerview.widget.DiffUtil
import com.anri.exampleapp.domain.model.PostModel

class BaseDiffUtil<T: PostModel>: DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.isIdDiff(newItem)
    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem.isContentDiff(newItem)
    override fun getChangePayload(oldItem: T, newItem: T) = oldItem.getPayloadDiff(newItem)
}