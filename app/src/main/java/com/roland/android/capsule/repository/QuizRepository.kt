package com.roland.android.capsule.repository

interface QuizRepository {

	fun start()

	fun getNextQuestion()

	fun getPreviousQuestion()

	fun selectAnswer(answer: String?)

	fun submit()

	fun reset()

}