package com.coco.mvvm.data.model

import com.google.gson.annotations.SerializedName

class a : ArrayList<QuoteModel>()

data class QuoteModel(
    @SerializedName("id") val id: Int? = 0, // 1
    @SerializedName("author") val author: String? = "", // Franklin D. Roosevelt
    @SerializedName("quote") val quote: String? = "" // The only limit to our realization of tomorrow is our doubts of today.
)