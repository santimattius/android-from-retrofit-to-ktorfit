package com.santimattius.basic.skeleton.di

import com.santimattius.basic.skeleton.core.data.CharactersRepository
import com.santimattius.basic.skeleton.core.data.service.CharacterServices
import com.santimattius.basic.skeleton.core.networking.KtorfitServiceCreator
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton

@Module
class AppModule {

    @Singleton
    fun provideServiceCreator(): KtorfitServiceCreator {
        return KtorfitServiceCreator(baseUrl = "https://dragonball-api.com/api/")
    }

    @Singleton
    fun provideCharacterService(serviceCreator: KtorfitServiceCreator): CharacterServices {
        return serviceCreator.createCharacterServices()
    }

    @Singleton
    fun provideCharacterRepository(service: CharacterServices): CharactersRepository {
        return CharactersRepository(service)
    }
}