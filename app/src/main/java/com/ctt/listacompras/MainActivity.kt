package com.ctt.listacompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

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
            when {
                produtoDigitado.text.isEmpty() -> pdtDigitado.error = "Insira o nome do produto!"
                precoDigitado.text.isEmpty() -> prcDigitado.error = "Insira o preço do produto!"
                else -> {
                    val lista = Intent(this, ListaProdutosActivity::class.java)
                    lista.putExtra("NOMEPRODUTO", produtoDigitado.text)
                    lista.putExtra("PRECOPRODUTO", precoDigitado.text)
                    startActivity(lista)
                    produtoDigitado.text = ""
                    precoDigitado.text = ""
                }
            }
        }
    }
}