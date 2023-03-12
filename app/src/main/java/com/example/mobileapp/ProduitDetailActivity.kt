package com.example.mobileapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProduitDetailActivity  : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produit_detail)
        val nom = intent.getStringExtra("nom")
        val description = intent.getStringExtra("description")
        val pictureUrl = intent.getStringExtra("picture_url")
        setHeaderTxt(nom)
        showBack()
        findViewById<TextView>(R.id.textviewDescription).setText(description)
        Picasso.get().load(pictureUrl).into(findViewById<ImageView>(R.id.imageviewProduitDetail))

    }
}