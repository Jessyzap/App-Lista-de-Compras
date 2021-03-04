package com.ctt.listacompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var botao: Button
    private lateinit var produtoDigitado: TextView
    private lateinit var precoDigitado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botao = findViewById(R.id.btn)
        produtoDigitado = findViewById(R.id.pdtDigitado)
        precoDigitado = findViewById(R.id.prcDigitado)

        botao.setOnClickListener {
            val lista = Intent(this, ListaProdutosActivity::class.java)
            lista.putExtra("NOMEPRODUTO", produtoDigitado.text)
            lista.putExtra("PRECOPRODUTO", precoDigitado.text)
            startActivity(lista)
            produtoDigitado.setText("")
            precoDigitado.setText("")
        }
    }
}