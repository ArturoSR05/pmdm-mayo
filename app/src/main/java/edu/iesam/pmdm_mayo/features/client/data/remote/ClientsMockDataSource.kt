package edu.iesam.pmdm_mayo.features.client.data.remote

import edu.iesam.pmdm_mayo.features.client.domain.Client
import org.koin.core.annotation.Single

@Single
class ClientsMockDataSource {

    fun getClients(): List<Client> {
        return listOf(
            Client("657932156S", "Alberto", "alberto.10@gmail.com"),
            Client("120347657P", "Sofia", "sofi-02@gmail.com"),
            Client("746812036L", "Gabriel", "gabrielillo12@gmail.com"),
            Client("478623255I", "Diego", "diegoj9@gmail.com"),
            Client("145324563G", "Paula", "lapaula78@gmail.com"),
            Client("456789652F", "Belen", "portaldebelen@gmail.com"),
            Client("789654123D", "Francisco", "francis43@gmail.com"),
            Client("781563256B", "Daniela", "daniferna@gmail.com")
        )
    }
}