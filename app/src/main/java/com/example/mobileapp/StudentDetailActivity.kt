package com.example.mobileapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.squareup.picasso.Picasso


class StudentDetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_detail)
        val image=findViewById<ImageView>(R.id.imageStudent)
        val linkOut = findViewById<Button>(R.id.linkOut)
        if(intent.extras!=null){
            val url=intent.extras!!.getString("url","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj0AEwRdUSWfs2LPDlLKn9kI-KvverDKfy0w&usqp=CAU");
            Picasso.get().load(url).into(image);
            val title=intent.extras!!.getString("title","Epsi")
            setHeaderTxt(title)
        }

        linkOut.setOnClickListener(View.OnClickListener {
            val url = "https://www.epsi.fr"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })



        showBack()


    }
}