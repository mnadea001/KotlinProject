package com.example.mobileapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProduitAdapter  (val produits: ArrayList<Produit>):RecyclerView.Adapter<ProduitAdapter.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val textViewNom = view.findViewById<TextView>(R.id.textviewNomProduit)
        val textViewDesc = view.findViewById<TextView>(R.id.textviewDescriptionProduit)
        val imgViewImg = view.findViewById<ImageView>(R.id.imageviewProduit)
        val layoutContent= view.findViewById<LinearLayout>(R.id.layoutcontentProduit)
        init {
            textViewDesc.maxLines = 2
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produit, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produit = produits.get(position)
        holder.textViewNom.text=produit.name
        holder.textViewDesc.text=produit.description
        Picasso.get().load(produit.picture_url).into(holder.imgViewImg)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ProduitDetailActivity::class.java)
            intent.putExtra("nom", produit.name)
            intent.putExtra("description", produit.description)
            intent.putExtra("picture_url", produit.picture_url)
            holder.itemView.context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return produits.size
    }

}