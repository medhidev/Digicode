package com.btssio.ozenne.digicode.model

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.btssio.ozenne.digicode.R
import com.btssio.ozenne.digicode.controller.DataActivity

class Adapter(private val salles: List<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

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
        val salleName = salles[position]
        holder.textView.text = salleName

        // action executer sur toutes les salles
        holder.itemView.setOnClickListener(){
            val context = holder.itemView.context
            val intent = Intent(context, DataActivity::class.java)
            context.startActivity(intent)
        }
    }

    // Nombre de salles
    override fun getItemCount() = salles.size
}