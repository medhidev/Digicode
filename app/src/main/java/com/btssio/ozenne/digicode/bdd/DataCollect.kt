package com.btssio.ozenne.digicode.bdd
import java.sql.ResultSet

class List_Code(val id_salle:Int, val digicode:Int, val wifi_key:String)
class DataCollect {
    fun processData(rs: ResultSet): ArrayList<List_Code>{
        val output = ArrayList<List_Code>()

        // Champs de récupération
        while (rs.next()) {
            val id_salle = rs.getInt("id_salle")
            val digicode = rs.getInt("digicode")
            val wifi_key = rs.getString("wifi_key")
            val data = List_Code(id_salle, digicode, wifi_key)
            output.add(data)
        }

        return output
    }
}