package edu.iesam.pmdm_mayo.features.client.domain

import org.koin.core.annotation.Single

@Single
class GetClientsUseCase(private val clientRepository: ClientRepository) {

    suspend operator fun invoke(): List<Client> {
        return clientRepository.getClients()
    }
}