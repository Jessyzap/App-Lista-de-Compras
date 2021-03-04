package com.ctt.listacompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.listacompras.model.Produto

class ListaProdutosActivity : AppCompatActivity() {

    private lateinit var botaoRemover: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_produtos)

        // dados da intent do botão 'Adicionar'
        val produto = intent.extras?.get("NOMEPRODUTO").toString()
        val preco = intent.extras?.get("PRECOPRODUTO").toString().toDouble()

        // colocar a lista no adapter
        val rvProdutos = findViewById<RecyclerView>(R.id.listaProdutos)
        val rvProdutosAdapter = ProdutosAdapter(listaCompanion) // lista estática de produtos
        rvProdutos.adapter = rvProdutosAdapter
        rvProdutos.layoutManager = LinearLayoutManager(this)

        // adicionar item pelo adapter
        rvProdutosAdapter.adicionarProduto(Produto(produto, preco))

        // remover item selecionado
        botaoRemover = findViewById(R.id.btnRemover)
        botaoRemover.setOnClickListener() {
            rvProdutosAdapter.removerProduto()
        }
    }

    companion object {
        val listaCompanion: MutableList<Produto> = mutableListOf(
            Produto("Maçã", 4.00),
            Produto("Abacaxi", 3.00),
            Produto("Ameixa", 2.00),
            Produto("Uva", 4.00),
            Produto("Pera", 3.00),
            Produto("Morango", 5.00),
            Produto("Pêssego", 2.00)
        )
    }
}