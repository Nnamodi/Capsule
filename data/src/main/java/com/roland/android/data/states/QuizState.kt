package com.roland.android.data.states

import com.roland.android.data.data_source.questions
import com.roland.android.domain.entity.Question
import kotlinx.coroutines.flow.MutableStateFlow

data class UiState(
	val quizQuestions: MutableList<Question> = questions,
	val currentQuestion: Question = quizQuestions[0],
	val result: QuizResult? = null,
	val quizHalfFinished: Boolean = false,
	val time: TimeState = TimeState(),
	val quizStarted: Boolean = false,
)

val uiState = MutableStateFlow(UiState())

val time = MutableStateFlow(TimeState())