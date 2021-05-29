package com.dicoding.caca.fundamental1.network

import com.dicoding.caca.fundamental1.data.model.FollowersResponse
import com.dicoding.caca.fundamental1.data.model.FollowingResponse
import com.dicoding.caca.fundamental1.data.model.SearchResponse
import com.dicoding.caca.fundamental1.data.model.UserDetailModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface APIAsisst {
    @GET("search/users?")
    fun getUserObject(
        @Query("q") q:String
    ): Call<SearchResponse>

    @GET("users/{username}")
    fun getDetailUser(
        @Path("username") username:String
    ): Call<UserDetailModel>

    @GET("users/{username}/followers")
    fun getFollowerResponse(
        @Path("username") username:String
    ): Call<FollowersResponse>

    @GET("users/{username}/following")
    fun getFollowingResponse(
        @Path("username") username:String
    ): Call<FollowingResponse>
}