package com.example.aadknewsapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception



class NewsViewModel: ViewModel() {

    private val articlesFlow = MutableStateFlow<List<Article>>(emptyList())

    fun getNews(category: String) {

        viewModelScope.launch(Dispatchers.IO) {

            try {
                val response = RetrofitHelper.newsService.fetchHeadLines(
                    country = "in" ,
                    category = "" ,
                    apiKey = Constants.API_KEY
                )
                Log.d("News Response", response.articles.toString())

                articlesFlow.emit(response.articles)
            }  catch (e:Exception) {
                Log.e("NewsViewModel", e.toString())
            }
        }


        }
    fun getArticlesFlow(): StateFlow<List<Article>>{
        return articlesFlow.asStateFlow()

    }
}