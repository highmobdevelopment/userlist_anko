package com.erevacation.networking

import com.erevacation.networking.networkmodel.ListNM
import com.erevacation.networking.networkmodel.ProductNM
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("highmobdevelopment/userlist/master/contacts.json")
    fun getList(): Observable<MutableList<ListNM>>
}