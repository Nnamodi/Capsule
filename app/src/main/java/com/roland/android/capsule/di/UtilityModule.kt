package com.roland.android.capsule.di

import com.roland.android.capsule.util.Timing
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UtilityModule {

	@Provides
	@Singleton
	fun providesTiming() = Timing()
}