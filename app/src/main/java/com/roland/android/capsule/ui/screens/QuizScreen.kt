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
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.LiveHelp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
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
import com.roland.android.capsule.data.Questions
import com.roland.android.capsule.data.previewQuestions
import com.roland.android.capsule.ui.components.CustomIconButton
import com.roland.android.capsule.ui.components.Option
import com.roland.android.capsule.ui.components.QuestionsTag
import com.roland.android.capsule.ui.theme.CapsuleTheme

@Composable
fun QuizScreen(
	questions: List<Questions>,
	currentQuestionId: Int
) {
	val currentQuestion by remember(currentQuestionId) {
		derivedStateOf { questions[currentQuestionId] }
	}
	val options = listOf(currentQuestion.option1, currentQuestion.option2, currentQuestion.option3, currentQuestion.option4)
	var selectedOption by rememberSaveable { mutableStateOf("") }

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
				currentQuestionId = currentQuestionId
			)
			Spacer(Modifier.width(10.dp))
			CustomIconButton(
				onClick = {},
				contentDescription = stringResource(R.string.help_icon_desc),
				icon = Icons.Rounded.LiveHelp
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
				text = stringResource(R.string.question, currentQuestionId, questions[currentQuestionId].question),
				modifier = Modifier.padding(10.dp),
				style = MaterialTheme.typography.headlineSmall
			)
		}

		options.forEach { option ->
			Option(
				modifier = Modifier.fillMaxWidth(),
				option = option,
				selected = option == selectedOption,
				onOptionSelect = { selectedOption = it }
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
				onClick = {},
				contentDescription = stringResource(R.string.prev_button),
				icon = Icons.Rounded.ArrowBackIosNew,
				enabled = currentQuestionId > 1
			)
			Spacer(Modifier.weight(1f))
			CustomIconButton(
				onClick = {},
				contentDescription = stringResource(R.string.next_button),
				icon = Icons.Rounded.ArrowForwardIos,
				enabled = currentQuestionId < 10
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun QuizScreenPreview() {
	CapsuleTheme {
		QuizScreen(questions = previewQuestions, currentQuestionId = 2)
	}
}