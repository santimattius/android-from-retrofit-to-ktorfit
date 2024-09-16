package com.santimattius.basic.skeleton.core.data

import com.santimattius.basic.skeleton.core.data.dto.CharacterResponse
import com.santimattius.basic.skeleton.core.domain.Character
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class CharactersRepository(
    private val httpClient: HttpClient,
) {

    suspend fun getCharacters() = runCatching {
        val response = httpClient.get("characters").body<CharacterResponse>()
        response.asCharacterDomainModel()
    }

}

private fun CharacterResponse.asCharacterDomainModel(): List<Character> {
    return items.map {
        Character(
            id = it.id,
            name = it.name,
            image = it.image,
            description = it.description,
            affiliation = it.affiliation
        )
    }
}
