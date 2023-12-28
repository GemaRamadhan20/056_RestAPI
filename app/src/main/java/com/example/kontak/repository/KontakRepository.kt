package com.example.kontak.repository

import com.example.kontak.model.Kontak
import com.example.kontak.network.KontakService

interface KontakRepository {
    suspend fun getKontak(): List<Kontak>
    suspend fun insertKontak(kontak: Kontak)
    suspend fun updateKontak(id: Int, kontak: Kontak)
    suspend fun deleteKontak(id: Int)
    suspend fun getKontakById(id: Int): Kontak
}

class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository {

    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()
}