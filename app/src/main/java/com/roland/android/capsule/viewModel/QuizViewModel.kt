package com.roland.android.capsule.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.Player
import com.roland.android.capsule.data.UiState
import com.roland.android.capsule.data.uiState
import com.roland.android.capsule.repository.QuizRepository
import com.roland.android.capsule.util.Actions
import com.roland.android.capsule.util.Timing
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
	private val quizRepository: QuizRepository,
	val player: Player,
	private val timing: Timing
) : ViewModel() {
	var quizUiState by mutableStateOf(UiState()); private set

	init {
		viewModelScope.launch {
			timing.time.collect { time ->
				uiState.update { it.copy(time = time) }
			}
		}
		viewModelScope.launch {
			uiState.collectLatest {
				quizUiState = it
			}
		}
		player.prepare()
	}

	fun actions(action: Actions) {
		try {
			when (action) {
				Actions.Start -> quizRepository.start()
				Actions.NextQuestion -> quizRepository.getNextQuestion()
				Actions.PreviousQuestion -> quizRepository.getPreviousQuestion()
				is Actions.SelectAnswer -> quizRepository.selectAnswer(action.answer)
				Actions.Submit -> quizRepository.submit()
				Actions.Reset -> quizRepository.reset()
			}
			Log.i("ActionsInfo", "Action: $action")
		} catch (e: Exception) {
			Log.i("ActionsInfo", "Error message: ${e.message}")
			return
		}
	}
}