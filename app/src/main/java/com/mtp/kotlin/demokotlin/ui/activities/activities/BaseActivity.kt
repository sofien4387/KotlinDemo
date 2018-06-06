package com.mtp.kotlin.demokotlin.ui.activities.activities

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.mtp.kotlin.demokotlin.R
import com.mtp.kotlin.demokotlin.mvp.models.presenter.BasePresenter
import com.mtp.kotlin.demokotlin.mvp.models.view.BaseView

abstract class BaseActivity<P : BasePresenter<BaseView>> : BaseView, AppCompatActivity() {

    protected lateinit var presenter: P;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        presenter = initPresenter();
    }

    protected abstract fun initPresenter(): P

    override fun getContext(): Context {
        return this;
     }
}
