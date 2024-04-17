package com.btssio.ozenne.digicode.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.btssio.ozenne.digicode.R
import com.btssio.ozenne.digicode.repository.CodeRepository
import java.util.Calendar

class MainActivity : AppCompatActivity() {

        private var date_select = ""
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // Recherche ID XML
            val btn_search_salle = findViewById<Button>(R.id.search_salle) // Bouton de recherche
            val datePicker = findViewById<DatePicker>(R.id.calendar)
            val today = Calendar.getInstance() // Date Actuelle

            // Création Calendar
            datePicker.init(today.get(Calendar.YEAR),
                today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH))
            {
                view, year, month, day ->
                val formatMonth = String.format("%02d", month + 1) // Mois forme Liste (commence à 0)
                val formatDay = String.format("%02d", day) // Permet l'affichage du 0 devant
                date_select = "$formatDay/$formatMonth/$year"
            }

            // Redirection via le bouton search
            btn_search_salle.setOnClickListener {
                if (date_select.isEmpty())
                    Toast.makeText(this, "Aucune date sélectionnée", Toast.LENGTH_SHORT).show()
                else{
                    Toast.makeText(this, "Date sélectionnée : $date_select", Toast.LENGTH_SHORT).show() // Affichage date
                    val intent_liste_salle = Intent(this, ListeSalleActivity::class.java)
                    intent_liste_salle.putExtra("date_select", date_select)
                    startActivity(intent_liste_salle) // Redirection Action
                }
            }
        }
}