package com.roland.android.capsule.data

import com.roland.android.capsule.util.Constant.ALLOTTED_TIME_MILLIS
import com.roland.android.capsule.util.Constant.START_TIME
import kotlinx.coroutines.flow.MutableStateFlow

data class UiState(
	val quizQuestions: MutableList<Question> = questions,
	val currentQuestion: Question = quizQuestions[0],
	val result: Result? = null,
	val quizHalfFinished: Boolean = false,
	val time: Time = Time(),
	val quizStarted: Boolean = false,
)

val uiState = MutableStateFlow(UiState())

data class Result(
	val remark: String = "",
	val score: String = "",
	val answeredQuestions: Int = 0,
	val correctAnswers: Int = 0
)

data class Time(
	val formattedTime: String = START_TIME,
	val timeInMillis: Long = ALLOTTED_TIME_MILLIS,
	val timeUp: Boolean = false
)