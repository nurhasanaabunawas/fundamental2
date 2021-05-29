package com.dicoding.caca.fundamental1.util

class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> isSuccess(data: T): Resource<T> = Resource(Status.SUCCESS, data, null)
        fun <T> isError(data: T?, message: String?): Resource<T> =
                Resource(Status.ERROR, data, message)

        fun <T> isLoading(data: T?): Resource<T> = Resource(Status.LOADING, data, null)
    }
}