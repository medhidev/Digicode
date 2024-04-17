package com.btssio.ozenne.digicode.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.btssio.ozenne.digicode.R
import com.btssio.ozenne.digicode.model.Salle_Adapter
import com.btssio.ozenne.digicode.repository.CodeRepository

class ListeSalleActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var salleAdapter: Salle_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste_salle)
        recyclerView = findViewById(R.id.recyclerview)
        val btn_retour_recherche = findViewById<Button>(R.id.back_search)
        val codeRepository = CodeRepository(this@ListeSalleActivity)

        // Mettre les salle de l'objet Code dans un tableau
        val liste_code = codeRepository.getCode()
        val date_select = intent.getStringExtra("date_select")?: ""

        // affichage des salles
        recyclerView.layoutManager = LinearLayoutManager(this)
        salleAdapter = Salle_Adapter(liste_code, date_select)
        salleAdapter.updateData(liste_code)
        recyclerView.adapter = salleAdapter

        btn_retour_recherche.setOnClickListener(){
            val intent_recherche_salle = Intent(this, MainActivity::class.java) // Redirection Action
            startActivity(intent_recherche_salle)
        }

    }
}