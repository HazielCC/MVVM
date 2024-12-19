package com.coco.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coco.mvvm.model.QuoteModel
import com.coco.mvvm.model.QuoteProvider

class QuoteViewModel : ViewModel() {
    // LiveData object to hold the quote
    val quoteProvider = MutableLiveData<QuoteModel>()

    fun getQuoteProvider() {
        val value = QuoteProvider.getQuote()
        quoteProvider.value = value
    }
}