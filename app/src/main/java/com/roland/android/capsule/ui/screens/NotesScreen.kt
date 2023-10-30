package com.roland.android.capsule.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roland.android.capsule.R
import com.roland.android.capsule.ui.components.UpNextButton
import com.roland.android.capsule.ui.theme.CapsuleTheme

@Composable
fun NotesScreen(navigateToNextScreen: () -> Unit) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.verticalScroll(rememberScrollState()),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text(
			text = stringResource(R.string.note_title),
			modifier = Modifier.padding(top = 16.dp),
			style = MaterialTheme.typography.headlineLarge
		)
		Text(stringResource(R.string.note_body))
		Spacer(Modifier.height(50.dp))
		Spacer(Modifier.weight(1f))
		UpNextButton(
			modifier = Modifier.fillMaxWidth(),
			nextScreenTitle = R.string.quiz_test,
			nextScreenDescription = R.string.ten_questions,
			navigateToNextScreen = navigateToNextScreen
		)
	}
}

@Preview(showBackground = true)
@Composable
private fun NotesScreenPreview() {
	CapsuleTheme {
		NotesScreen {}
	}
}