package com.santimattius.basic.skeleton.core.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    @SerialName("items") val items: List<CharacterDto>,
)