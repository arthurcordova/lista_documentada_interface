package com.proway.listainterfaceevents.interfaces

import com.proway.listainterfaceevents.model.Produto

interface ClickableProduto {

    fun onClickDelete(positon: Int, produto: Produto)
    fun onClickEdit(produto: Produto)

}