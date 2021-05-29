package com.dicoding.caca.fundamental1.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserDetailModel(
    @Expose
    @SerializedName("login")
    val login: String?,

    @Expose
    @SerializedName("Id")
    val Id:Int?,

    @Expose
    @SerializedName("node_id")
    val node_id:String?,

    @Expose
    @SerializedName("avatar_url")
    val avatarUrl:String?,

    @Expose
    @SerializedName("gravatar_id")
    val gravatar_id:String?,

    @Expose
    @SerializedName("url")
    val url:String?,

    @Expose
    @SerializedName("html_url")
    val html_url:String?,

    @Expose
    @SerializedName("followes_url")
    val follower_url:String?,

    @Expose
    @SerializedName("following_url")
    val following_url:String?,

    @Expose
    @SerializedName("gists_url")
    val gists_url:String?,

    @Expose
    @SerializedName("starred_url")
    val starred_url:String?,

    @Expose
    @SerializedName("subsriptions_url")
    val subscriptions_url:String?,

    @Expose
    @SerializedName("organizations_url")
    val organizations_url:String?,

    @Expose
    @SerializedName("repos_url")
    val repos_url:String?,

    @Expose
    @SerializedName("events_url")
    val events_url:String?,

    @Expose
    @SerializedName("received_events_url")
    val received_events_url:String?,

    @Expose
    @SerializedName("type")
    val type:String?,

    @Expose
    @SerializedName("side_admin")
    val site_admin:Boolean?,

    @Expose
    @SerializedName("name")
    val name:String?,

    @Expose
    @SerializedName("twitter_username")
    val twitter_username :String?,

    @Expose
    @SerializedName("email")
    val email:String?,

    @Expose
    @SerializedName("hireable")
    val hireable:String?,

    @Expose
    @SerializedName("bio")
    val bio:String?,

    @Expose
    @SerializedName("company")
    val company:String?,

    @Expose
    @SerializedName("blog")
    val blog:String?,

    @Expose
    @SerializedName("location")
    val location:String?,

    @Expose
    @SerializedName("public_repository")
    val public_repository:String?,

    @Expose
    @SerializedName("public_gists")
    val public_gists:String?,

    @Expose
    @SerializedName("followers")
    val followers:String?,

    @Expose
    @SerializedName("following")
    val following:String?,

    @Expose
    @SerializedName("created_at")
    val created_at :String?,

    @Expose
    @SerializedName("updated_at")
    val update_at:String?
)

