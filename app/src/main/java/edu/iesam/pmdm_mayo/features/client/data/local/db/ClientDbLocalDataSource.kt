package edu.iesam.pmdm_mayo.features.client.data.local.db

import org.koin.core.annotation.Single

@Single
class ClientDbLocalDataSource(private val clientDao: ClientDao) {

    suspend fun getClients(): List<ClientEntity> {
        return clientDao.getAllClients()
    }

    suspend fun insertClient(client: ClientEntity) {
        clientDao.insertClient(client)
    }

    suspend fun insertClients(clients: List<ClientEntity>) {
        clientDao.insertClients(clients)
    }

    suspend fun deleteClient(client: ClientEntity) {
        clientDao.deleteClient(client)
    }

    suspend fun updateClient(client: ClientEntity) {
        clientDao.updateClient(client)
    }
}