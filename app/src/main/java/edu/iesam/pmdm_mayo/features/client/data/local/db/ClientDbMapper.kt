package edu.iesam.pmdm_mayo.features.client.data.local.db

import edu.iesam.pmdm_mayo.features.client.domain.Client

fun ClientEntity.toDomain(): Client {
   return Client(
        dni = this.dni,
        name = this.name,
        email = this.email
   )
}

fun Client.toEntity(): ClientEntity {
    return ClientEntity(
        dni = this.dni,
        name = this.name,
        email = this.email
    )
}

