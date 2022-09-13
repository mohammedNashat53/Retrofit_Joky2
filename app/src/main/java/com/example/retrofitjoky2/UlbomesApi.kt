package com.example.retrofitjoky2

import retrofit2.Response
import retrofit2.http.GET

interface UlbomesApi {
@GET("/albums")
suspend fun getUlbomes(): Response<List<Ulbomes>>
}