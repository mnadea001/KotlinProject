package com.example.mobileapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.json.JSONObject


class StudentDetailActivity : BaseActivity() {

    //        data student
    val data = "{\n" +
            "  \"items\": [\n" +
            "    {\n" +
            "      \"nom\": \"Allan\",\n" +
            "      \"email\": \"allan@epsi.fr\",\n" +
            "      \"prenom\": \"Bordeaux\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"nom\": \"Arraud\",\n" +
            "      \"email\": \"arraud@epsi.fr\",\n" +
            "      \"prenom\": \"Bordeaux\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"nom\": \"Nicolas\",\n" +
            "      \"email\": \"nicolas@epsi.fr\",\n" +
            "      \"prenom\": \"Bordeaux\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"nom\": \"Lilian\",\n" +
            "      \"email\": \"lilian@epsi.fr\",\n" +
            "      \"prenom\": \"Bordeaux\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"nom\": \"Maxime\",\n" +
            "      \"email\": \"maxime@epsi.fr\",\n" +
            "      \"prenom\": \"Bordeaux\"\n" +
            "    }\n" +
            "  ]\n" +
            "}"

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

//information
        val students = arrayListOf<Student>()
        val jsStudents = JSONObject(data)
        val jsArrayStudent = jsStudents.getJSONArray("items")

        for (i in 0 until jsArrayStudent.length()) {
            val jsStudent = jsArrayStudent.getJSONObject(i)
            val student = Student(
                jsStudent.optString("nom", ""),
                jsStudent.optString("prenom", ""),
                jsStudent.optString("email", "")
            )
            students.add(student)
        }

        val recyclerviewStudents = findViewById<RecyclerView>(R.id.recyclerviewStudents)
        recyclerviewStudents.layoutManager = LinearLayoutManager(this)
        val studentAdapter = StudentAdapter(students)
        recyclerviewStudents.adapter = studentAdapter


        showBack()


    }
}