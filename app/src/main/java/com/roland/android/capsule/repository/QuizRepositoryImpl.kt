package com.roland.android.capsule.repository

import android.content.Context
import com.roland.android.capsule.R
import com.roland.android.capsule.data.Result
import com.roland.android.capsule.data.uiState
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(
	@ApplicationContext private val context: Context
) : QuizRepository {

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

	override fun selectAnswer(answer: String?) {
		val currentQuestionId = uiState.value.currentQuestion.id
		val answeredQuestion = uiState.value.quizQuestions[currentQuestionId]
		answeredQuestion.selectedOption = answer
		val questions = uiState.value.quizQuestions
		questions[currentQuestionId] = answeredQuestion
		uiState.update { it.copy(quizQuestions = questions) }
	}

	override fun submit() {
		val questions = uiState.value.quizQuestions
		val answeredQuestions = questions.filter { it.selectedOption != null }.size
		val correctAnswers = questions.filter { it.selectedOption == it.answer }.size
		val divisor = 100.0 / questions.size
		val score = correctAnswers * divisor
		val remark = when (score) {
			in 0.0..20.9 -> context.getString(R.string.not_good)
			in 21.0..40.9 -> context.getString(R.string.fair)
			in 41.0..60.9 -> context.getString(R.string.satisfactory)
			in 61.0..80.9 -> context.getString(R.string.very_good)
			in 81.0..95.0 -> context.getString(R.string.excellent)
			else -> context.getString(R.string.congratulations)
		}
		val result = Result(
			remark = remark,
			score = "$score%",
			answeredQuestions = answeredQuestions,
			correctAnswers = correctAnswers
		)
		uiState.update { it.copy(result = result) }
	}
}