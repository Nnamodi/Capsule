package com.roland.android.capsule.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.Player
import com.roland.android.capsule.data.UiState
import com.roland.android.capsule.util.Actions
import com.roland.android.data.states.time
import com.roland.android.data.states.uiState
import com.roland.android.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
	private val useCase: UseCase,
	val player: Player
) : ViewModel() {
	var quizUiState by mutableStateOf(UiState()); private set

	init {
		viewModelScope.launch {
			time.collect { time ->
				uiState.update { it.copy(time = time) }
			}
		}
		viewModelScope.launch {
			uiState.collectLatest {
				val state = UiState(
					it.quizQuestions,
					it.currentQuestion,
					it.result,
					it.quizHalfFinished,
					it.time,
					it.quizStarted
				)
				quizUiState = state
			}
		}
		player.prepare()
	}

	fun actions(action: Actions) {
		try {
			when (action) {
				Actions.Start -> useCase.start()
				Actions.NextQuestion -> useCase.getNextQuestion()
				Actions.PreviousQuestion -> useCase.getPreviousQuestion()
				is Actions.SelectAnswer -> useCase.selectAnswer(action.answer)
				Actions.Submit -> useCase.submit()
				Actions.Reset -> useCase.reset()
			}
			Log.i("ActionsInfo", "Action: $action")
		} catch (e: Exception) {
			Log.i("ActionsInfo", "Error message: ${e.message}")
			return
		}
	}
}