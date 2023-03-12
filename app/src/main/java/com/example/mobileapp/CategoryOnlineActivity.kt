package com.example.mobileapp

import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class CategoryOnlineActivity : BaseActivity() {

    companion object {
        private const val KEY_CATEGORY = "category"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_online)
        showBack()
        setHeaderTxt("Catégories")

        val categories = arrayListOf<Category>()

        val listviewCategories = findViewById<ListView>(R.id.listviewCategories)
        val categoryAdapter = CategoryAdapter(this, categories, ::onCategoryClick)
        listviewCategories.adapter = categoryAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestUrl = "https://www.ugarit.online/epsi/categories.json"
        val request =
            Request.Builder().url(mRequestUrl).cacheControl(CacheControl.FORCE_NETWORK).build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val data = response.body()?.string()
                if (data != null) {
                    val jsCategories = JSONObject(data)
                    val jsArrayCategory = jsCategories.getJSONArray("items")

                    for (i in 0 until jsArrayCategory.length()) {
                        val jsCategory = jsArrayCategory.getJSONObject(i)
                        val category = Category(
                            jsCategory.optString("category_id", "Not found"),
                            jsCategory.optString("title", "Not found"),
                            jsCategory.optString("product_url", "Not found")
                        )
                        categories.add(category)
                    }
                    runOnUiThread(Runnable {
                        categoryAdapter.notifyDataSetChanged()
                    })

                    Log.e("WS", data)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread(Runnable {
                    Toast.makeText(application, e.message, Toast.LENGTH_SHORT).show()
                })
            }

        })
    }


    private fun onCategoryClick(category: Category) {
        print("Hello")
    }
}