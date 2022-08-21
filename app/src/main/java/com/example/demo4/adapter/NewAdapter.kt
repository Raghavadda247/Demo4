package com.example.demo4.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.demo4.databinding.ItemLayoutBinding
import com.example.demo4.data.model.Article
import com.example.demo4.data.model.News


class NewAdapter() : Adapter<NewAdapter.ArticleViewHolder>(){
    var newsList:List<Article>?=null


    fun setNews(newsList: List<Article>?){
        this.newsList=newsList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): ArticleViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val binding=ItemLayoutBinding.inflate(layoutInflater,parent,false)
         return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        newsList?.let {
            it[position]?.let { holder.bind(it) }}
    }

    override fun getItemCount(): Int {
        return newsList?.let { it.size }?:0
    }
    class ArticleViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: Article){
            binding.artcleItem=data
            binding.executePendingBindings()
        }
    }
    companion object{
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(newsImage: ImageView, url:String){
            Glide.with(newsImage)
                .load(url)
                .into(newsImage)
        }
    }


}