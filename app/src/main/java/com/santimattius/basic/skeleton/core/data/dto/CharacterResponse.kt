package com.santimattius.basic.skeleton.core.data.dto


import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("items") val items: List<CharacterDto>,
)