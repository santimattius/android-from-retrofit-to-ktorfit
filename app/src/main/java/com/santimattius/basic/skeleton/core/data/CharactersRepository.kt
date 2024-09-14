package com.santimattius.basic.skeleton.core.data

import com.santimattius.basic.skeleton.core.data.dto.CharacterResponse
import com.santimattius.basic.skeleton.core.data.service.CharacterServices
import com.santimattius.basic.skeleton.core.domain.Character

class CharactersRepository(
    private val service: CharacterServices,
) {

    suspend fun getCharacters() = runCatching { service.getCharacters().asCharacterDomainModel() }

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
