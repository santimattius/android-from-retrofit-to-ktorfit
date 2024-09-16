package com.santimattius.basic.skeleton.di

import com.santimattius.basic.skeleton.core.data.CharactersRepository
import com.santimattius.basic.skeleton.core.networking.httpClient
import io.ktor.client.HttpClient
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton

@Module
class AppModule {

    @Singleton
    fun provideHttpClient(): HttpClient {
        return httpClient(baseUrl = "https://dragonball-api.com/api/")
    }

    @Singleton
    fun provideCharacterRepository(httpClient: HttpClient): CharactersRepository {
        return CharactersRepository(httpClient)
    }
}