package com.btssio.ozenne.digicode.controller

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.btssio.ozenne.digicode.R
import com.btssio.ozenne.digicode.model.Adapter
import com.btssio.ozenne.digicode.repository.CodeRepository

class ListeSalleActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste_salle)
        recyclerView = findViewById(R.id.recyclerview)
        val codeRepository = CodeRepository(this@ListeSalleActivity)

        // Mettre les salle de l'objet Code dans un tableau
        val liste_code = codeRepository.getCode()
        val salleNames = mutableListOf<String>()
        for (code in liste_code)
            salleNames.add(code.nom_salle)

        // affichage des salles
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(salleNames)
        recyclerView.adapter = adapter

    }
}