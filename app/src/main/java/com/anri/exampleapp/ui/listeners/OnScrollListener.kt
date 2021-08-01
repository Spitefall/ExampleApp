package com.anri.exampleapp.ui.listeners

import androidx.recyclerview.widget.RecyclerView

abstract class OnScrollListener(val itemCountRecycler:() -> Int, val firstVisibleItemPosition:() -> Int, private val pageThreshold: Int = 5) :
    RecyclerView.OnScrollListener() {

    var previousTotal = 0
    private var loading = true
    private var refreshing = true

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = recyclerView.childCount
        val totalItemCount = itemCountRecycler()
        val firstVisibleItemPosition = firstVisibleItemPosition()

        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false
                previousTotal = totalItemCount
            }
        }
        val visibleThreshold = pageThreshold
        if (!loading && !refreshing && totalItemCount - visibleItemCount <= firstVisibleItemPosition + visibleThreshold && totalItemCount > 9) {
            onLoadMore()
            loading = true
        }
    }

    fun stopPagination() {
        loading = true
    }

    fun reset() {
        loading = false
        previousTotal = 0
    }

    fun resetLoading() {
        loading = false
    }

    fun updateRefreshing(refreshing: Boolean) {
        this.refreshing = refreshing
    }

    abstract fun onLoadMore()
}