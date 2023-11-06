package com.roland.android.domain.repository

interface TimerRepository {

	fun start()

	fun pause(timeUp: Boolean = false)

	fun restart()

}