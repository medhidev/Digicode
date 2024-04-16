package com.btssio.ozenne.digicode.repository

import android.content.Context
import android.util.Log
import com.btssio.ozenne.digicode.model.Code
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class CodeRepository (private val context: Context){

    private var codes: List<Code> = listOf()

    // Charge les codes au démarrage du repository.
    init {
        codes = loadCode()
    }

    fun getCode():List<Code>{
        return codes
    }

    private fun loadCode(): List<Code> {
        val jsonFileString = getJsonDataFromAsset(context, "data.json")
        if (jsonFileString == null) { // Error
            Log.e("CodeRepository", "JSON data is null")
            return emptyList()
        }
        val gson = Gson()
        val listCodeType = object : TypeToken<List<Code>>() {}.type
        val liste_codes = gson.fromJson<List<Code>>(jsonFileString, listCodeType) ?: emptyList()

        return liste_codes
    }

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        return try {
            context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            Log.e("CodeRepository", "Error reading from $fileName", ioException)
            null
        }
    }
}