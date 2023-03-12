package com.example.mobileapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button

class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setHeaderTxt("Home")
        val buttonStudentList = findViewById<Button>(R.id.buttonStudentList)
        val buttonCategoryList = findViewById<Button>(R.id.buttonCategoryList)
//        add background on buttons
        buttonStudentList.setBackgroundColor(Color.parseColor("#F5F749"))
        buttonCategoryList.setBackgroundColor(Color.parseColor("#F5F749"))
//        add event on click
        buttonStudentList.setOnClickListener(View.OnClickListener {
            val intent = Intent(application, StudentListActivity::class.java)
            startActivity(intent)
        })

    }
}