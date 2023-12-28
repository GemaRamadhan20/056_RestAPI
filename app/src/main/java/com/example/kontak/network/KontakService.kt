package com.example.kontak.network

import com.example.kontak.model.Kontak
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface KontakService {
    @Headers(
        "Accept: application/json"
    )
    @GET("siswa.json")
    suspend fun getKontak(): List<Kontak>

    @GET("kontak/{id}")
    suspend fun getKontakById(@Path("id") id: Int): Kontak
}