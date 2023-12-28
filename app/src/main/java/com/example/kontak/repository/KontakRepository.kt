package com.example.kontak.repository

import com.example.kontak.model.Kontak
import com.example.kontak.network.KontakService

interface KontakRepository {
    /** Fetches List Of Kontak From KontakAPI */
    suspend fun getKontak(): List<Kontak>
}

class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository {

    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()
}