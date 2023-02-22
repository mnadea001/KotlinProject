package com.example.mobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(val students: ArrayList<Student>) :
    RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textViewNom = view.findViewById<TextView>(R.id.textViewNom)
            val textViewEmail = view.findViewById<TextView>(R.id.textViewEmail)
            val textViewPrenom = view.findViewById<TextView>(R.id.textViewPrenom)
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.cell_student, viewGroup, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val student = students.get(position)
            holder.textViewNom.text = student.nom
            holder.textViewPrenom.text = student.prenom
            holder.textViewEmail.text = student.email
        }

        override fun getItemCount(): Int {
            return students.size
        }
    }
