package com.silpa_m.wallapp.di

import android.content.Context
import com.silpa_m.wallapp.WallAppApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesContext(@ApplicationContext context: Context): WallAppApplication {
        return context as WallAppApplication
    }


    @Provides
    fun provideHttpInterceptor(): HttpLoggingInterceptor? {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    fun provideClient(
        interceptor: HttpLoggingInterceptor?/*,
        tokenInterceptor: TokenInterceptor?*/
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            // .addInterceptor(tokenInterceptor)
            .build()
    }

    @Provides
    fun providesRetrofit(@ApplicationContext context: Context, client: OkHttpClient): Retrofit {
        /* val url = if (BuildConfig.IS_BETA) {
             Constants.betaApi
         } else {
             Constants.prodApi
         }*/

        val url = "https://maps.googleapis.com/maps/api/place/"

        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}