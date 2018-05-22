package com.erevacation.networking

import com.erevacation.networking.networkmodel.ProductNM
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("/v1/product/index")
    fun getProducts(@Query("action") action: String): Observable<ProductNM>
}