package com.example.mobileapp

import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class StudentDetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_detail)
        val image=findViewById<ImageView>(R.id.imageStudent)
        if(intent.extras!=null){
            val url=intent.extras!!.getString("url","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj0AEwRdUSWfs2LPDlLKn9kI-KvverDKfy0w&usqp=CAU");
            Picasso.get().load(url).into(image);
            val title=intent.extras!!.getString("title","Epsi")
            setHeaderTxt(title)
        }

        showBack()


    }
}