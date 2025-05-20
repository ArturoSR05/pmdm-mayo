package edu.iesam.pmdm_mayo.features.client.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val CLIENT_DNI = "dni"
const val NAME_TABLE = "Clients"


@Entity(tableName = NAME_TABLE)
data class ClientEntity (
    @PrimaryKey @ColumnInfo(name = CLIENT_DNI) val dni: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "email") val email: String
)