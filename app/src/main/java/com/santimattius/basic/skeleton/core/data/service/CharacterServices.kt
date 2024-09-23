package com.santimattius.basic.skeleton.core.data.service

import com.santimattius.basic.skeleton.core.data.dto.CharacterResponse
import de.jensklingenberg.ktorfit.http.GET

interface CharacterServices {

    @GET("characters")
    suspend fun getCharacters(): CharacterResponse

}