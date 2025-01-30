package com.santimattius.basic.skeleton.di

import com.santimattius.basic.skeleton.core.data.CharactersRepository
import com.santimattius.basic.skeleton.core.data.service.CharacterServices
import com.santimattius.basic.skeleton.core.networking.RetrofitServiceCreator
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton

@Module
class AppModule {

    @Singleton
    fun provideRetrofitCreator(): RetrofitServiceCreator {
        return RetrofitServiceCreator(baseUrl = "https://dragonball-api.com/api/")
    }

    @Singleton
    fun provideCharacterService(serviceCreator: RetrofitServiceCreator): CharacterServices {
        return serviceCreator.create()
    }

    @Singleton
    fun provideCharacterRepository(service: CharacterServices): CharactersRepository {
        return CharactersRepository(service)
    }
}