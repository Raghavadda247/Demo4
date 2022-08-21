package com.example.demo4.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo4.BR
import com.example.demo4.R
import com.example.demo4.databinding.ActivityMainBinding
import com.example.demo4.viewmodel.NewViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel=setViewModel()
        setupBinding(viewModel)
    }

    private fun setupBinding(viewModel: NewViewModel) {
        val activityMainBinding:ActivityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        activityMainBinding.setVariable(BR.viewModel,viewModel)
        activityMainBinding.executePendingBindings()
        recyclerView.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)

        }
    }

    private fun setViewModel() :NewViewModel{
        val viewModel= ViewModelProvider(this).get(NewViewModel::class.java)
        viewModel.getObserver().observe(this, Observer{
            it?.let {
                    viewModel.setAdapterData(it)
            }
        })
        viewModel.fetchNews()
        return viewModel
    }
}
