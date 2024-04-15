package com.btssio.ozenne.digicode.repository

import android.content.Context
import com.btssio.ozenne.digicode.model.Code
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileReader

class CodeRepository (){
//    private val appContext = context.applicationContext
//    val assetManager: AssetManager = appContext.assets
//
//    val jsonFile = assetManager.open("data.json")
//    val jsonString = jsonFile.bufferedReader().use { it.readText() }
//
//    val gson = Gson()
//    val dataList: List<Code> = gson.fromJson(jsonString, object : TypeToken<List<Code>>() {}.type)

    val codes: List<Code>

    init {
        val file = File("C:\\Users\\oxyblade\\Documents\\Code\\Kotlin\\Digicode\\app\\src\\main\\assets\\data.json")
        val fileReader = FileReader(file)
        val gson = Gson()
        val listType = object : TypeToken<List<Code>>() {}.type
        codes = gson.fromJson(fileReader, listType)
    }
}