package com.example.demo4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide


class NewAdapter (val context: Context,val articles:List<Article>): Adapter<NewAdapter.ArticleViewHolder>(){
    class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var newsImage = itemView.findViewById<ImageView>(R.id.newsImage)
        var newsTitle=itemView.findViewById<TextView>(R.id.newTitle)
        var newsDescritption=itemView.findViewById<TextView>(R.id.newDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article:Article = articles[position]
        holder.newsTitle.text=article.title
        holder.newsDescritption.text=article.description
        Glide.with(context).load(article.urlToImage).into(holder.newsImage)
    }

    override fun getItemCount(): Int {
        return  articles.size
    }
}