package com.roland.android.capsule.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
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

				Capsule(
					uiState = viewModel.quizUiState,
					actions = viewModel::actions
				)
			}
		}
	}
}