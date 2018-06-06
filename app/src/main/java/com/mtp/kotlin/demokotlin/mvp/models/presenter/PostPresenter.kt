package com.mtp.kotlin.demokotlin.mvp.models.presenter

import android.content.Context
import com.mtp.kotlin.demokotlin.R
import com.mtp.kotlin.demokotlin.app.PostApi
import com.mtp.kotlin.demokotlin.mvp.models.view.PostView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Sofien on 03/06/2018.
 */
class PostPresenter(v: PostView) : BasePresenter<PostView>(v) {

    @Inject
    lateinit var postApi: PostApi

    private var subscription: Disposable? = null

    override fun onAttachView(context: Context) {
        super.onAttachView(context)
        loadPosts()
    }

    private fun loadPosts() {
        view.showLoading()
        subscription = postApi
                .getPosts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { postList -> view.updatePosts(postList) },
                        { view.showError(R.string.unknown_error) }
                )
    }

    override fun onDetachView() {
        super.onDetachView()
        subscription?.dispose()
    }
}