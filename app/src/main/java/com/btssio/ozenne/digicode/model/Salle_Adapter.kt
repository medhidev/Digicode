package com.btssio.ozenne.digicode.model

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.btssio.ozenne.digicode.R
import com.btssio.ozenne.digicode.controller.DataActivity

class Salle_Adapter(private var codes: List<Code>, private val date_select: String) : RecyclerView.Adapter<Salle_Adapter.ViewHolder>() {

    // Appel de l'item Cible (evite les répétitions)
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textViewSalle) // Référence du textView de la salle
    }

    // Creation d'un View Holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_salle, parent, false)
        return ViewHolder(view)
    }

    // Mettre le nom de salle pour chaque items
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // Données récupérer dans la liste de l'objet Code
        val date = codes[position].date
        val salleName = codes[position].nom_salle
        val digicode = codes[position].digicode
        val wifikey = codes[position].wifikey

        if (date_select == date)
            holder.textView.text = salleName
        else
            holder.itemView.visibility = View.GONE // cache les autres item

        // Injection des données sur la salle cible
        holder.itemView.setOnClickListener(){
            val context = holder.itemView.context
            val intent = Intent(context, DataActivity::class.java).apply{
                putExtra("DIGICODE", digicode.toString())
                putExtra("WIFI", wifikey)
                putExtra("SALLE", salleName)
            }
            context.startActivity(intent)
        }
    }

    // Méthode pour mettre à jour la liste de données / Les triés
    fun updateData(list_codes: List<Code>) {
        val sortedList = mutableListOf<Code>() // Liste a afficher
        val otherList = mutableListOf<Code>() // Liste a cacher

        // Séparer les salles qui correspondent à la date sélectionnée et les autres salles
        for (code in list_codes) {
            if (code.date == date_select) {
                sortedList.add(code)
            } else {
                otherList.add(code)
            }
        }

        // Priorise l'affichage de la sortedList
        sortedList.addAll(otherList)

        // Mettre à jour de l'affichage avec la nouvelle liste triée
        codes = sortedList
        notifyDataSetChanged()
    }

    // Nombre de salles
    override fun getItemCount() = codes.size // Donne indirectement le nombres de salle
}