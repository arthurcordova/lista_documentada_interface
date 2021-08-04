package com.proway.listainterfaceevents.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.proway.listainterfaceevents.R
import com.proway.listainterfaceevents.interfaces.ClickableProduto
import com.proway.listainterfaceevents.model.Produto

/**
 * Depois de criar o ViewHolder -> passar a classe no tipo do Adapter
 * Ex: RecyclerView.Adapter<ItemProdutoViewHolder>()
 *
 */
class ProdutosAdapter(
    var parametroListaDeProdutos: MutableList<Produto>,
    val parametroIterface: ClickableProduto
) :
    RecyclerView.Adapter<ItemProdutoViewHolder>() {

    /**
     * Define o layout para cada item da nossa lista. Link com o arquivo XML
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemProdutoViewHolder {
        /**
         * Convertemos o nosso arquivo XML em uma VIEW
         */
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_lista_produto, parent, false)
        return ItemProdutoViewHolder(itemView)

    }

    /**
     * Manipulamos os dados de cada item (tela x elemento + index)
     * Aqui que jogamos os dados para a tela, e add os eventos como o de click
     */
    override fun onBindViewHolder(itemProdutoViewHolder: ItemProdutoViewHolder, position: Int) {
        val tvID = itemProdutoViewHolder.itemView.findViewById<TextView>(R.id.idTextView)
        val tvNome = itemProdutoViewHolder.itemView.findViewById<TextView>(R.id.nomeTextView)
        val tvPreco = itemProdutoViewHolder.itemView.findViewById<TextView>(R.id.precoTextView)

        val dataClassProduto = parametroListaDeProdutos[position]

        tvID.text = dataClassProduto.id
        tvNome.text = dataClassProduto.nome
        tvPreco.text = dataClassProduto.preco.toString()

        val btnDelete = itemProdutoViewHolder.itemView.findViewById<Button>(R.id.deleteButton)
        val btnEdit = itemProdutoViewHolder.itemView.findViewById<Button>(R.id.editButton)

        btnDelete.setOnClickListener { parametroIterface.onClickDelete(position, dataClassProduto) }
        btnEdit.setOnClickListener { parametroIterface.onClickEdit(dataClassProduto) }

    }

    /**
     * Define quantos elementos a o recycler view irá precisar criar
     */
    override fun getItemCount(): Int {
        return parametroListaDeProdutos.size
    }


    fun refresh(listaAtualizada: MutableList<Produto>) {
        parametroListaDeProdutos = listaAtualizada
        notifyDataSetChanged()
    }

}

/**
 * Primeiro criar esta classe.
 */
class ItemProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}