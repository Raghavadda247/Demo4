package com.example.demo4.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo4.adapter.NewAdapter
import com.example.demo4.databinding.ActivityMainBinding
import com.example.demo4.viewmodel.NewViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var adapter: NewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerView()
        setViewModel()

    }

    private fun setRecyclerView() {
        binding.newsList.layoutManager = LinearLayoutManager(this)
        adapter = NewAdapter(this)
        binding.newsList.adapter = adapter
    }

    private fun setViewModel() {
        val viewModel: NewViewModel = ViewModelProvider(this).get(NewViewModel::class.java)
        viewModel.getObserver().observe(this, Observer {
            it?.let {
                with(adapter) {
                    setNews(it)
                    notifyDataSetChanged()
                }
            }
        })
        viewModel.fetchNews()
    }
}
