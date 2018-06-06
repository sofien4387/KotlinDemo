package com.mtp.kotlin.demokotlin.ui.activities.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.mtp.kotlin.demokotlin.R
import com.mtp.kotlin.demokotlin.RecyclerAdapter
import com.mtp.kotlin.demokotlin.databinding.ActivityMainBinding
import com.mtp.kotlin.demokotlin.mvp.models.model.Nasa
import com.mtp.kotlin.demokotlin.mvp.models.presenter.PostPresenter
import com.mtp.kotlin.demokotlin.mvp.models.view.PostView

class MainActivity : BaseActivity<PostPresenter>(), PostView{

    private lateinit var binding : ActivityMainBinding
    private var postsAdapter = RecyclerAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.adapter = postsAdapter

         presenter.onAttachView(this)

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetachView()
    }
    override fun updatePosts(posts: List<Nasa>) {
        postsAdapter.updatePosts(posts)
    }

    override fun showError(error: String) = Toast.makeText(this, error, Toast.LENGTH_LONG).show()

    override fun showLoading() {
        binding.progressVisibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
    }

    override fun initPresenter(): PostPresenter {
        return PostPresenter(this)
    }

}
