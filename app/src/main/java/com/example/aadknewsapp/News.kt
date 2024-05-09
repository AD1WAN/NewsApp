package com.example.aadknewsapp

import com.google.gson.annotations.SerializedName

data class News(

      @SerializedName("totalResults") val totalResults: Int,
      val articles: List<Article>

)
