package edu.iesam.pmdm_mayo.features.client.presentation.adapter

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.pmdm_mayo.R
import edu.iesam.pmdm_mayo.features.client.domain.Client

class ClientViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val dniText: TextView = view.findViewById(R.id.dni)
    private val nameText: TextView = view.findViewById(R.id.name)
    private val emailText: TextView = view.findViewById(R.id.email)

    fun bind(client: Client) {
        dniText.text = client.dni
        nameText.text = client.name
        emailText.text = client.email
    }
}