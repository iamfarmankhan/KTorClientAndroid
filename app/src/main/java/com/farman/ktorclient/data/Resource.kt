package com.farman.ktorclient.data

import com.farman.ktorclient.model.ErrorBody

sealed class Resource<out R> {
    data class Success<out R>(val result: R): Resource<R>()
    data class Failure(val errorBody: ErrorBody): Resource<Nothing>()
    object Loading: Resource<Nothing>()
}