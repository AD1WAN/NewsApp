package com.example.aadknewsapp

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("author") val authorName: String,
    @SerializedName("title") val titleText: String,
    @SerializedName("description") val descText: String,
    @SerializedName("url") val articleUrl: String,
    @SerializedName("urlToImage") val imageUrl: String,

)


/*"author": "Jak Connor",
"title": "Elon Musk reveals Twitter has discovered a hidden layer of 'censorship'",
"description": "Elon Musk has sat down for an interview where he discusses overall censorship and if new laws should be introduced to protect users from private companies. Continue reading at TweakTown >",
"url": "https://www.tweaktown.com/news/91728/elon-musk-reveals-twitter-has-discovered-hidden-layer-of-censorship/index.html",
"urlToImage": "https://static.tweaktown.com/news/9/1/91728_25_elon-musk-reveals-twitter-has-discovered-hidden-layer-of-censorship_full.png",
"publishedAt": "2023-06-05T12:04:03Z",
"content": "During an interview with The Babylon Bee at Twitter headquarters, Elon Musk has discussed censorship by private companies such as Google and if new laws should be introduced that protect users from p… [+2451 chars]"*/