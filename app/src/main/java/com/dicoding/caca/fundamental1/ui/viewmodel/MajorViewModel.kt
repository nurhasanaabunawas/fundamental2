package com.dicoding.caca.fundamental1.ui.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.caca.fundamental1.data.model.*
import com.dicoding.caca.fundamental1.network.APIUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MajorViewModel : ViewModel() {

    companion object {
        private const val TAG = "MajorViewModel"
    }

    fun getUsers(query: String): LiveData<ArrayList<UserSearchModel>> {
        val searchResult = MutableLiveData<ArrayList<UserSearchModel>>()
        APIUser.getApiAsisst().getUserObject(query).enqueue(object : Callback<SearchResponse> {
            override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                if (response.isSuccessful) {
                    searchResult.value = response.body()?.items as ArrayList<UserSearchModel>
                } else {
                    Log.e(TAG, "on)Failure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return searchResult
    }


    fun getUserDetail(username: String): LiveData<UserDetailModel> {
        val detailUser = MutableLiveData<UserDetailModel>()
        APIUser.getApiAsisst().getDetailUser(username).enqueue(object : Callback<UserDetailModel> {
            override fun onResponse(call: Call<UserDetailModel>, response: Response<UserDetailModel>) {
                if (response.isSuccessful) {
                    detailUser.value = response.body()
                } else {
                    Log.e(TAG, "on)Failure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<UserDetailModel>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return detailUser

    }

    fun getFollowers(query: String) : LiveData<ArrayList<UserSearchModel>> {
        val FollowerResponse = MutableLiveData<ArrayList<UserSearchModel>>()
        APIUser.getApiAsisst().getFollowerResponse(query).enqueue(object : Callback<FollowersResponse> {
            override fun onResponse(call: Call<FollowersResponse>, response: Response<FollowersResponse>) {
                if (response.isSuccessful) {
                    FollowerResponse.value = response.body()?.followersUrl as ArrayList<UserSearchModel>
                } else {
                    Log.e(TAG, "on)Failure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<FollowersResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return FollowerResponse
    }



    fun getFollowing(query: String)  : LiveData<ArrayList<UserSearchModel>> {
        val FollowingResponse = MutableLiveData<ArrayList<UserSearchModel>>()
        APIUser.getApiAsisst().getFollowingResponse(query).enqueue(object : Callback<FollowingResponse> {
            override fun onResponse(call: Call<FollowingResponse>, response: Response<FollowingResponse>) {
                if (response.isSuccessful) {
                    FollowingResponse.value = response.body()?.followingUrl as ArrayList<UserSearchModel>
                } else {
                    Log.e(TAG, "on)Failure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<FollowingResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return FollowingResponse
    }
}
