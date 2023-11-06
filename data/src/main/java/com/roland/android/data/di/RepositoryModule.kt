package com.roland.android.data.di

import com.roland.android.data.repository.QuizRepositoryImpl
import com.roland.android.data.repository.TimerRepositoryImpl
import com.roland.android.domain.repository.QuizRepository
import com.roland.android.domain.repository.TimerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

	@Binds
	abstract fun bindQuizRepository(quizRepositoryImpl: QuizRepositoryImpl): QuizRepository

	@Binds
	abstract fun bindTimerRepository(timerRepositoryImpl: TimerRepositoryImpl): TimerRepository

}