package com.roland.android.capsule.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.roland.android.capsule.ui.theme.CapsuleTheme

@Composable
fun QuizScreen() {
	Column(
		modifier = Modifier.fillMaxSize()
	) {}
}

@Preview(showBackground = true)
@Composable
fun QuizScreenPreview() {
	CapsuleTheme {
		QuizScreen()
	}
}