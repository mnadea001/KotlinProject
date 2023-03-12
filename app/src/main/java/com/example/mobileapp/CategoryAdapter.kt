package com.example.mobileapp

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter (val categories: ArrayList<Category>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){

        val textViewNom = view.findViewById<TextView>(R.id.textViewTitle)
        val layoutContent= view.findViewById<LinearLayout>(R.id.layoutContentCategory)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_category, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, index: Int) {
        val category = categories.get(index)

        holder.textViewNom.text=category.title
        holder.layoutContent.setOnClickListener(View.OnClickListener {
            val intent = Intent(holder.layoutContent.context, ProduitListActivity::class.java)
            intent.putExtra("categorieTitle", category.title)
            intent.putExtra("url", category.products_url)

            holder.layoutContent.context.startActivity(intent)

        })
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}