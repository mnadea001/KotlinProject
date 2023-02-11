package com.example.mobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val buttonStudentList=findViewById<Button>(R.id.buttonStudentList)
        buttonStudentList.setOnClickListener(View.OnClickListener {
            val intent= Intent(application,StudentListActivity::class.java)
            startActivity(intent)
        })

    }
}