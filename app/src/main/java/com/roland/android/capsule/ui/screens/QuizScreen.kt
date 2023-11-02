package com.roland.android.capsule.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Announcement
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roland.android.capsule.R
import com.roland.android.capsule.data.UiState
import com.roland.android.capsule.data.questions
import com.roland.android.capsule.ui.components.CustomButton
import com.roland.android.capsule.ui.components.CustomIconButton
import com.roland.android.capsule.ui.components.Option
import com.roland.android.capsule.ui.components.QuestionsTag
import com.roland.android.capsule.ui.dialog.HelpDialog
import com.roland.android.capsule.ui.theme.CapsuleTheme
import com.roland.android.capsule.util.Actions

@Composable
fun QuizScreen(
	uiState: UiState,
	actions: (Actions) -> Unit,
	navigateToAnotherScreen: (Int?) -> Unit
) {
	val (questions, currentQuestion, result, quizHalfFinished) = uiState
	val options = listOf(currentQuestion.option1, currentQuestion.option2, currentQuestion.option3, currentQuestion.option4)
	var selectedOption by rememberSaveable(currentQuestion) { mutableStateOf(currentQuestion.selectedOption) }
	val openHelpDialog = remember { mutableStateOf(false) }

	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(horizontal = 20.dp)
			.verticalScroll(rememberScrollState()),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Row(
			modifier = Modifier.padding(top = 10.dp),
			verticalAlignment = Alignment.CenterVertically
		) {
			QuestionsTag(
				modifier = Modifier
					.fillMaxHeight()
					.weight(1f),
				currentQuestionId = currentQuestion.id + 1,
				numberOfQuestions = questions.size
			)
			Spacer(Modifier.width(10.dp))
			CustomIconButton(
				onClick = { openHelpDialog.value = true },
				contentDescription = stringResource(R.string.help_icon_desc),
				icon = Icons.Outlined.Announcement
			)
		}

		Box(
			modifier = Modifier
				.fillMaxWidth()
				.padding(vertical = 20.dp)
				.border(
					width = 2.dp,
					color = MaterialTheme.colorScheme.onBackground,
					shape = MaterialTheme.shapes.medium
				)
		) {
			Text(
				text = stringResource(R.string.question, (currentQuestion.id + 1), currentQuestion.question),
				modifier = Modifier.padding(10.dp),
				style = MaterialTheme.typography.headlineSmall
			)
		}

		options.forEach { option ->
			Option(
				modifier = Modifier.fillMaxWidth(),
				option = option,
				selected = option == selectedOption,
				quizTaken = result != null,
				onOptionSelect = {
					selectedOption = it
					actions(Actions.SelectAnswer(it))
				}
			)
		}

		Spacer(Modifier.height(20.dp))
		Spacer(Modifier.weight(1f))

		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(bottom = 20.dp)
		) {
			CustomIconButton(
				onClick = { actions(Actions.PreviousQuestion) },
				contentDescription = stringResource(R.string.prev_button),
				icon = Icons.Rounded.ArrowBackIosNew,
				enabled = currentQuestion.id > 0
			)
			if ((currentQuestion.id == questions.lastIndex) && (result == null) && quizHalfFinished) {
				CustomButton(
					modifier = Modifier.weight(1f),
					nextScreenTitle = R.string.submit
				) {
					actions(Actions.Submit)
					navigateToAnotherScreen(null)
				}
			} else { Spacer(Modifier.weight(1f)) }
			CustomIconButton(
				onClick = { actions(Actions.NextQuestion) },
				contentDescription = stringResource(R.string.next_button),
				icon = Icons.Rounded.ArrowForwardIos,
				enabled = currentQuestion.id < questions.lastIndex
			)
		}
	}

	if (openHelpDialog.value) {
		HelpDialog(
			quizTaken = result != null,
			reset = { navigateToAnotherScreen(0); actions(it) },
			closeDialog = { openHelpDialog.value = false }
		)
	}
}

@Preview(showBackground = true)
@Composable
fun QuizScreenPreview() {
	CapsuleTheme {
		QuizScreen(UiState(currentQuestion = questions[3]), {}) {}
	}
}