package com.roland.android.capsule.data

import kotlinx.coroutines.flow.MutableStateFlow

data class UiState(
	val quizQuestions: MutableList<Question> = questions,
	val currentQuestion: Question = quizQuestions[0]
)

val uiState = MutableStateFlow(UiState())