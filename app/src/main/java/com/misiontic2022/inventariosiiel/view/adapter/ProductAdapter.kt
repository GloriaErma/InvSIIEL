package com.misiontic2022.inventariosiiel.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.misiontic2022.inventariosiiel.R
import com.misiontic2022.inventariosiiel.model.productd
import com.squareup.picasso.Picasso

//el error del ViewHolder se soluciona al agregar la clase viewHolder
class ProductAdapter(val productListener: ProductListener) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder> () {

    var listProducts = ArrayList<productd>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_productd,parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val prod = listProducts[position]
        //productd.kt app\src\main\java\com\misiontic2022\inventariosiiel\model\productd.kt
        holder.tvNameProduct.text = prod.nombre
        holder.tvPriceProduct.text = prod.precio
        Picasso.get().load(prod.url).into(holder.ivItemProduct)

        holder.itemView.setOnClickListener {
            productListener.onProductsClick(prod, position)
        }
    }

    override fun getItemCount()= listProducts.size

    fun updateData(data: List<productd>) {
        listProducts.clear()
        listProducts.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNameProduct = itemView.findViewById<TextView>(R.id.tvNameProduct)
        val tvPriceProduct = itemView.findViewById<TextView>(R.id.tvPriceProduct)
        val ivItemProduct = itemView.findViewById<ImageView>(R.id.ivItemProduct)
    }
}
