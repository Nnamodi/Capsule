package com.roland.android.capsule.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.hilt.navigation.compose.hiltViewModel
import com.roland.android.capsule.ui.dialog.WelcomeDialog
import com.roland.android.capsule.ui.screens.Capsule
import com.roland.android.capsule.ui.theme.CapsuleTheme
import com.roland.android.capsule.viewModel.QuizViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			CapsuleTheme {
				val viewModel: QuizViewModel = hiltViewModel()
				val openWelcomeDialog = rememberSaveable { mutableStateOf(true) }

				Capsule(
					uiState = viewModel.quizUiState,
					actions = viewModel::actions
				)

				if (openWelcomeDialog.value && !viewModel.quizUiState.quizStarted) {
					WelcomeDialog { openWelcomeDialog.value = false }
				}
			}
		}
	}
}