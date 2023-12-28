package com.example.kontak.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Kontak(
    val id: Int,
    val nama: String,
    val alamat: String,
    @SerialName(value = "telepon")
    val nohp: String,
)
