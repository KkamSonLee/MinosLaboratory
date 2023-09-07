package com.angdroid.minoslaboratory.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class MyData(
    @SerialName("id") val id: String, @SerialName("text") val text: String
)
