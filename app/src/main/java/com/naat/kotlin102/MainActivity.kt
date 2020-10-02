package com.naat.kotlin102

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val viewmodel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpListeners()
        setUpObservables()
    }

    private fun setUpObservables() {
        //definir observadores
        viewmodel.listBooks.observe(this, Observer { list ->
            val resultBooks = list?.joinToString() ?: "NO DATA"
            txtCryptos?.text = resultBooks
        })
    }

    private fun setUpListeners() {
        txtCryptos?.setOnClickListener {
            // pedir datos
            Log.e("Click", "ClickText")
            viewmodel.getLastBooks()
        }
    }
}