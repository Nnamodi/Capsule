package com.roland.android.capsule.data

import kotlinx.coroutines.flow.MutableStateFlow

data class UiState(
	val quizQuestions: MutableList<Question> = questions,
	val currentQuestion: Question = quizQuestions[0],
	val result: Result? = null,
	val quizHalfFinished: Boolean = false,
	val time: String = "1:00 min",
	val quizStarted: Boolean = false
)

val uiState = MutableStateFlow(UiState())

data class Result(
	val remark: String = "",
	val score: String = "",
	val answeredQuestions: Int = 0,
	val correctAnswers: Int = 0
)