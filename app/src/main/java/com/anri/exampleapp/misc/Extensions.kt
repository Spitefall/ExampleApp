package com.anri.exampleapp.misc

import android.widget.ImageView
import com.anri.exampleapp.di.modules.GlideApp
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.add(disposable: CompositeDisposable) {
    disposable.add(disposable)
}

fun ImageView.loadImage(url: String?) {
    GlideApp.with(context)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}

fun ImageView.loadImage(res: Int?) {
    GlideApp.with(context)
        .load(res)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}