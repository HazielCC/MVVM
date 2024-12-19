package com.coco.mvvm.data.model

class QuoteProvider {
    // Se agrega el companion object para que la función getQuote() sea estática
    companion object {
        var quotes: List<QuoteModel> = emptyList()
    }
}
