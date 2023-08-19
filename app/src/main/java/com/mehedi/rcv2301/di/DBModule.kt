package com.mehedi.rcv2301.di

import android.content.Context
import com.mehedi.rcv2301.db.LoveDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DBModule {

    //it is providing Love database
    @Provides
    @Singleton
    fun providesLoveDB(@ApplicationContext context: Context): LoveDatabase {
        return LoveDatabase.getDb(context)
    }


}