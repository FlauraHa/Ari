package com.flauraha.ari.data.model

import com.google.gson.annotations.SerializedName

data class Volume(
    @SerializedName("id")
    val id: String,
    @SerializedName("volumeInfo")
    val volumeInfo: VolumeInfo
)