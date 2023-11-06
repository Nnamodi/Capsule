package com.roland.android.domain.usecase

import com.roland.android.domain.repository.QuizRepository
import com.roland.android.domain.repository.TimerRepository
import javax.inject.Inject

class UseCase @Inject constructor(
	private val quizRepository: QuizRepository,
	private val timerRepository: TimerRepository
) {

	fun start() {
		timerRepository.start()
		quizRepository.start()
	}

	fun getNextQuestion() = quizRepository.getNextQuestion()

	fun getPreviousQuestion() = quizRepository.getPreviousQuestion()

	fun selectAnswer(answer: String?) = quizRepository.selectAnswer(answer)

	fun submit() {
		timerRepository.pause()
		quizRepository.submit()
	}

	fun reset() {
		timerRepository.restart()
		quizRepository.reset()
	}
}