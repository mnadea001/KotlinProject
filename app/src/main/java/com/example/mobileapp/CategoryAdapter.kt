package com.example.mobileapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CategoryAdapter(
    context: Context,
    categories: List<Category>,
    private val onClickListener: (Category) -> Unit
) : ArrayAdapter<Category>(context, android.R.layout.simple_list_item_1, categories) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_category, parent, false)

        val category = getItem(position)
        val titleTextView = view.findViewById<TextView>(R.id.textViewTitle)
        titleTextView.text = category?.title

        val productUrlTextView = view.findViewById<TextView>(R.id.textViewProductUrl)
        productUrlTextView.text = category?.products_url

        return view
    }
}