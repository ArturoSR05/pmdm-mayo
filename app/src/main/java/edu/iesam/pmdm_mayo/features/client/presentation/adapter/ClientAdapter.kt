package edu.iesam.pmdm_mayo.features.client.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.iesam.pmdm_mayo.R
import edu.iesam.pmdm_mayo.features.client.domain.Client

class ClientAdapter:ListAdapter<Client, ClientViewHolder>(ClientDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_client, parent, false)
        return ClientViewHolder(view)
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        val client = currentList[position]
        holder.bind(client)
    }
}