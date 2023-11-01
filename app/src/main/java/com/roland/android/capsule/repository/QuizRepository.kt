package com.roland.android.capsule.repository

interface QuizRepository {

	fun getNextQuestion()

	fun getPreviousQuestion()

	fun selectAnswer(answer: String?)

	fun submit()

}