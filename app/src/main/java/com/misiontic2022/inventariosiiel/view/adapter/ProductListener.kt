package com.misiontic2022.inventariosiiel.view.adapter

import com.misiontic2022.inventariosiiel.model.productd

interface ProductListener {
    fun onProductsClick(product:productd, position: Int)
}