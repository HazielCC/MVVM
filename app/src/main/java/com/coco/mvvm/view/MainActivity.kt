package com.coco.mvvm.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.coco.mvvm.R
import com.coco.mvvm.databinding.ActivityMainBinding
import com.coco.mvvm.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.viewContainer)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initUI()
    }

    private fun initUI() {
        setOnClickListeners()

        quoteViewModel.quoteProvider.observe(this) {
            binding.tvQuote.text = it.quote
            binding.tvAutor.text = it.author
        }
    }

    private fun setOnClickListeners() {
        binding.viewContainer.setOnClickListener {
            quoteViewModel.getQuoteProvider()
        }
    }
}