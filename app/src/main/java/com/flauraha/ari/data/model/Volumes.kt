package com.flauraha.ari.data.model

import com.google.gson.annotations.SerializedName

data class Volumes(
    @SerializedName("totalItems")
    val totalItems: Long,
    @SerializedName("items")
    val items: List<Volume>
)