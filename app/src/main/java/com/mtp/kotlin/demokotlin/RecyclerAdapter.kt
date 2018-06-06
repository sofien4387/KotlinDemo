package com.mtp.kotlin.demokotlin

import android.content.Context
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.mtp.kotlin.demokotlin.databinding.RecyclerviewItemRowBinding
import com.mtp.kotlin.demokotlin.mvp.models.model.Nasa

class RecyclerAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerAdapter.PostViewHolder>() {
    /**
     * The list of posts of the adapter
     */
    private var posts: List<Nasa> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: RecyclerviewItemRowBinding = DataBindingUtil.inflate(layoutInflater, R.layout.recyclerview_item_row, parent, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder?, position: Int) {
        holder?.bind(posts[position])
    }

    /**
     * Updates the list of posts of the adapter
     * @param posts the new list of posts of the adapter
     */
    fun updatePosts(posts: List<Nasa>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    /**
     * The ViewHolder of the adapter
     * @property binding the DataBinging object for Post item
     */
    class PostViewHolder(private val binding: RecyclerviewItemRowBinding) : RecyclerView.ViewHolder(binding.root) {
        /**
         * Binds a post into the view
         */
        fun bind(post: Nasa) {
            binding.post = post
            binding.executePendingBindings()
        }
    }
}