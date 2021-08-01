package com.anri.exampleapp.domain.model

interface PostModel {
    open fun isIdDiff(other: PostModel) : Boolean = this.hashCode() == other.hashCode()
    open fun isContentDiff(other : PostModel) : Boolean = this == other
    open fun getPayloadDiff(other: PostModel) : MutableList<Any> = mutableListOf()
}