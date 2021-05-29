package com.dicoding.caca.fundamental1.data.model

import com.google.gson.annotations.SerializedName

data class UserSearchModel(
        @field:SerializedName("login")
        val login: String?,

        @field:SerializedName("avatar_url")
        val avatarUrl: String?
)

