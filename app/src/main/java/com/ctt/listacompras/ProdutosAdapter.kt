package com.ctt.listacompras

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.listacompras.model.Produto

class ProdutosAdapter(private val listaProdutos: MutableList<Produto>) :
    RecyclerView.Adapter<ProdutosAdapter.ProdutoHolder>() {

    private val listaProdutosRemover = mutableListOf<Produto>()

    class ProdutoHolder(view: View) : RecyclerView.ViewHolder(view) {

        // dados do item da lista
        val nome: TextView = view.findViewById(R.id.nomeProduto)
        val preco: TextView = view.findViewById(R.id.precoProduto)
    }

    // criar item da lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_produto, parent, false)
        return ProdutoHolder(view)
    }

    // posicionar itens na lista
    override fun onBindViewHolder(holder: ProdutoHolder, position: Int) {

        holder.nome.text = listaProdutos[position].nomeProduto
        holder.preco.text = "%.2f".format(listaProdutos[position].precoProduto)
        holder.itemView.setBackgroundColor(Color.parseColor("#F4F1DE")) // cor padrão do item
        holder.itemView.setOnClickListener() {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFF3EBB9")) // cor do item selecionado
            listaProdutosRemover.add(listaProdutos[position])
            //Toast.makeText(it.context, listaProdutos[position].nomeProduto, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = listaProdutos.size

    fun adicionarProduto(produto: Produto) {
        listaProdutos.add(produto)
        notifyDataSetChanged()
    }

    fun removerProduto() {
        listaProdutos.removeAll(listaProdutosRemover)
        notifyDataSetChanged()
        ListaProdutosActivity.listaCompanion.removeAll(listaProdutosRemover)
        listaProdutosRemover.clear()
    }
}

