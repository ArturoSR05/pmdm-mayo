package edu.iesam.pmdm_mayo.features.client.domain

interface ClientRepository {

    suspend fun getClients(): List<Client>
}