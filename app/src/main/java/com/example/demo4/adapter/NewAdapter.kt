package com.example.demo4.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.demo4.databinding.ItemLayoutBinding
import com.example.demo4.data.model.Article
import com.example.demo4.data.model.News


class NewAdapter(private val activity: Activity) : Adapter<NewAdapter.ArticleViewHolder>(){
    var newsList: List<Article>?=null

    fun setNews(newsList: List<Article>){
        this.newsList=newsList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ArticleViewHolder {
        val binding=ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
         return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        newsList?.let {
            it[position]?.let {
                holder.bind(it, activity) } }
    }

    override fun getItemCount(): Int {
        return newsList?.let { it.size }?:0
    }
    class ArticleViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: Article, activity: Activity){
            val article:Article=data
            binding.newTitle.text= article.title
            binding.newDescription.text=article.description
            Glide.with(binding.newsImage)
                .load(article.urlToImage)
                .into(binding.newsImage)
        }
    }

}