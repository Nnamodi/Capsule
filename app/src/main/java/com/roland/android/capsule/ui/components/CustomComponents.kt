package com.roland.android.capsule.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.roland.android.capsule.R

@Composable
fun Option(
	modifier: Modifier,
	option: String,
	selected: Boolean,
	onOptionSelect: (String) -> Unit
) {
	val backgroundTint = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.tertiaryContainer
	val textColor = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onTertiaryContainer

	Box(
		modifier = modifier
			.padding(bottom = 10.dp)
			.clip(MaterialTheme.shapes.medium)
			.clickable { onOptionSelect(option) }
			.background(backgroundTint),
		contentAlignment = Alignment.Center
	) {
		Text(
			text = option,
			modifier = Modifier.padding(16.dp),
			color = textColor,
			textAlign = TextAlign.Center
		)
	}
}

@Composable
fun QuestionsTag(
	modifier: Modifier,
	currentQuestionId: Int,
	numberOfQuestions: Int
) {
	Box(
		modifier = modifier
			.clip(MaterialTheme.shapes.medium)
			.background(MaterialTheme.colorScheme.primary),
		contentAlignment = Alignment.Center
	) {
		Text(
			text = stringResource(R.string.questions_tag, currentQuestionId, numberOfQuestions),
			modifier = Modifier
				.fillMaxWidth()
				.padding(14.dp),
			color = MaterialTheme.colorScheme.onPrimary,
			textAlign = TextAlign.Center
		)
	}
}