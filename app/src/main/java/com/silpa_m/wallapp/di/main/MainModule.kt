package com.silpa_m.wallapp.di.main

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class MainModule {

   /* @Provides
    fun provideNearByApi(retrofit: Retrofit): NearbyApi {
        return retrofit.create(NearbyApi::class.java)
    }*/
}