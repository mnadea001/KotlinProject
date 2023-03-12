package com.example.mobileapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

open class BaseActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        }

        open fun setHeaderTxt(txt:String?) {
            val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
            textViewTitle.setText(txt)
        }

        open fun showBack(){
            val imageViewBack=findViewById<ImageView>(R.id.imageViewBack)
            imageViewBack.visibility=View.VISIBLE
            imageViewBack.setBackgroundColor(Color.parseColor("#9FA0C3"))
            imageViewBack.setOnClickListener(View.OnClickListener {
                finish()
            })
        }

}