package com.example.mobileapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ProduitListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_produit)

        val url = intent.getStringExtra("url")
        val title = intent.getStringExtra("categorieTitle")
        val produits = arrayListOf<Produit>()
        setHeaderTxt(title)
        showBack()
        val recyclerviewProduits = findViewById<RecyclerView>(R.id.recyclerViewProduits)
        recyclerviewProduits.layoutManager = LinearLayoutManager(this)
        val produitAdapter = ProduitAdapter(produits)
        recyclerviewProduits.adapter = produitAdapter
        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestUrl = url
        val request = Request.Builder().url(mRequestUrl).cacheControl(CacheControl.FORCE_NETWORK).build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val data = response.body()?.string()
                if (data != null) {
                    val jsCategories = JSONObject(data)
                    val jsArrayCategory = jsCategories.getJSONArray("items")

                    for (i in 0 until jsArrayCategory.length()) {
                        val jsCategory = jsArrayCategory.getJSONObject(i)
                        val produit = Produit(
                            jsCategory.optString("name", "Not found"),
                            jsCategory.optString("description", "Not found"),
                            jsCategory.optString("picture_url", "Not found")
                        )
                        produits.add(produit)
                    }
                    runOnUiThread(Runnable {
                        produitAdapter.notifyDataSetChanged()
                    })
                }
            }
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread(Runnable {
                    Toast.makeText(application, e.message, Toast.LENGTH_SHORT).show()
                })
            }

        })

    }


}