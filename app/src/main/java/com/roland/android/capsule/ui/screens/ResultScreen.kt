package com.roland.android.capsule.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roland.android.capsule.R
import com.roland.android.capsule.ui.theme.CapsuleTheme

@Composable
fun ResultScreen() {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(horizontal = 20.dp),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text(
			text = stringResource(R.string.no_result_yet),
			modifier = Modifier
				.padding(start = 20.dp, top = 64.dp, end = 20.dp),
			fontStyle = FontStyle.Italic,
			fontWeight = FontWeight.Light,
			style = MaterialTheme.typography.headlineMedium
		)
	}
}

@Preview(showBackground = true)
@Composable
private fun ResultScreenPreview() {
	CapsuleTheme {
		ResultScreen()
	}
}