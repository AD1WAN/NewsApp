package com.example.aadknewsapp


import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)

        val viewModel = ViewModelProvider(this)[NewsViewModel::class.java]



        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val helper: SnapHelper = LinearSnapHelper()
        helper.attachToRecyclerView(recyclerView)

        recyclerView.adapter = NewsAdapter(mutableListOf(), this@MainActivity)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        lifecycleScope.launch {
            viewModel.getNews("")
            
            withContext(Dispatchers.Main){
                progressBar.visibility = View.GONE
            }

            viewModel.getArticlesFlow().collect(){ articles->
                if (articles.isEmpty())  return@collect

                (recyclerView.adapter as NewsAdapter).addItems(articles)

            




        }
        }


    }



    }

