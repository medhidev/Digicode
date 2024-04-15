package com.btssio.ozenne.digicode.controller

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.btssio.ozenne.digicode.R
import com.btssio.ozenne.digicode.repository.CodeRepository

class ListeSalleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste_salle)
        val element_list = findViewById<Button>(R.id.accessList)

        val codeRepository = CodeRepository()
        val codeLu = codeRepository.codes
        codeLu.forEach {
            println("Digicode: ${it.digicode}, Wifikey: ${it.wifikey}, Salle: ${it.nom_salle}, Date: ${it.date}")
        }
    }
}