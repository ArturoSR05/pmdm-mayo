package edu.iesam.pmdm_mayo.features.client.data

import edu.iesam.pmdm_mayo.features.client.data.local.db.ClientDbLocalDataSource
import edu.iesam.pmdm_mayo.features.client.data.local.db.toDomain
import edu.iesam.pmdm_mayo.features.client.data.local.db.toEntity
import edu.iesam.pmdm_mayo.features.client.data.remote.ClientsMockDataSource
import edu.iesam.pmdm_mayo.features.client.domain.Client
import org.koin.core.annotation.Single

@Single
class ClientDataRepository(
    private val clientsMockDataSource: ClientsMockDataSource,
    private val clientDbLocalDataSource: ClientDbLocalDataSource) {

    suspend fun getClientList(): List<Client> {
        val localClients = clientDbLocalDataSource.getClients()
        return if (localClients.isNotEmpty()) {
            localClients.map { it.toDomain() }
        } else {
            val mockClients = clientsMockDataSource.getClients()
            if (mockClients.isNotEmpty()) {
                clientDbLocalDataSource.insertClients(mockClients.map { it.toEntity() })
            }
            mockClients
        }
    }
}