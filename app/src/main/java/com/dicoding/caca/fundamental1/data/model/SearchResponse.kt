package com.dicoding.caca.fundamental1.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @field:SerializedName("items")
    val items: List<UserSearchModel>
)
