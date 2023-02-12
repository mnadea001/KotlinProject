package com.example.mobileapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StudentListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)
        val buttonStudent1 = findViewById<Button>(R.id.button_student1)
        val buttonStudent2 = findViewById<Button>(R.id.button_student2)
        val buttonStudent3 = findViewById<Button>(R.id.button_student3)
//        add background on buttons
        buttonStudent1.setBackgroundColor(Color.parseColor("#F5F749"))
        buttonStudent2.setBackgroundColor(Color.parseColor("#F5F749"))
        buttonStudent3.setBackgroundColor(Color.parseColor("#F5F749"))

        setHeaderTxt("Infos")
        showBack()
    }

}