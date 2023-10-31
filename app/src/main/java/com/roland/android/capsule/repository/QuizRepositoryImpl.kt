package com.roland.android.capsule.repository

import com.roland.android.capsule.data.uiState
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor() : QuizRepository {

	override fun getNextQuestion() {
		val currentQuestionId = uiState.value.currentQuestion.id
		val nextQuestion = uiState.value.quizQuestions[currentQuestionId + 1]
		uiState.update { it.copy(currentQuestion = nextQuestion) }
	}

	override fun getPreviousQuestion() {
		val currentQuestionId = uiState.value.currentQuestion.id
		val previousQuestion = uiState.value.quizQuestions[currentQuestionId - 1]
		uiState.update { it.copy(currentQuestion = previousQuestion) }
	}
}