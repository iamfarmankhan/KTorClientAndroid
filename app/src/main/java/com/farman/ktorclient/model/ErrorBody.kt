package com.farman.ktorclient.model

import kotlinx.serialization.Serializable

@Serializable
data class ErrorBody(
    val status_code: Int=-1,
    val status_message: String="",
    val success: Boolean = false
)