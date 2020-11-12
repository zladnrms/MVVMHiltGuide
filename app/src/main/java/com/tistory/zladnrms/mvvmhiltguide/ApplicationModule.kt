package com.tistory.zladnrms.mvvmhiltguide

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext appContext: Context) : Context = appContext

    @Provides
    @Singleton
    fun provideResources(@ApplicationContext appContext: Context) : Resources = appContext.resources

}