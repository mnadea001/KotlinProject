package com.example.mobileapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
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

        buttonStudent1.setOnClickListener(View.OnClickListener {
            val url = "https://media.licdn.com/dms/image/D4E03AQF6AKZkd6n8YQ/profile-displayphoto-shrink_200_200/0/1669020728022?e=1681948800&v=beta&t=7_4-TZxqLq_lX6maxtsXflEdJJTKKdlsReoDDb3XD78"
            startImageActivity(url,getString(R.string.student_list_button1))
        })

        buttonStudent2.setOnClickListener(View.OnClickListener {
            val url = "https://media.licdn.com/dms/image/D4E35AQEtSrH6VNpFuQ/profile-framedphoto-shrink_800_800/0/1646042283242?e=1677664800&v=beta&t=OHcU7IGUVW4XsLEgTGQ8-gIUfnlQsPPi5yMXGEVH1pM"
            startImageActivity(url,getString(R.string.student_list_button2))
        })
        buttonStudent3.setOnClickListener(View.OnClickListener {
            val url = "https://media.licdn.com/dms/image/C4D03AQE-jTdsID5CYw/profile-displayphoto-shrink_200_200/0/1633015059108?e=1681948800&v=beta&t=Y3ErQgjcuPHIlwJpTMF82jpTqdgU7y-OsXkpk3ezvlg"
            startImageActivity(url,getString(R.string.student_list_button3))
        })


    }

    private fun startImageActivity(url: String, title: String) {
        val intent = Intent(application, StudentDetailActivity::class.java)
        intent.putExtra("url", url)
        intent.putExtra("title", title)
        startActivity(intent)
    }



}