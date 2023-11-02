package com.roland.android.capsule.ui.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LiveHelp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roland.android.capsule.R
import com.roland.android.capsule.ui.theme.CapsuleTheme
import com.roland.android.capsule.util.Actions

@Composable
fun InfoDialog(
	quizTaken: Boolean? = null,
	welcomeUser: Boolean = false,
	reset: (Actions) -> Unit = {},
	closeDialog: () -> Unit
) {
	val title = if (welcomeUser) R.string.welcome_greeting else R.string.help
	val text = when {
		welcomeUser -> R.string.welcome_message
		quizTaken == true -> R.string.help2
		else -> R.string.help1
	}
	val titleArrangement = if (welcomeUser) Arrangement.Center else Arrangement.Start
	val buttonText = when {
		welcomeUser -> R.string.start_button
		quizTaken == true -> R.string.reset
		else -> R.string.got_it
	}

	AlertDialog(
		onDismissRequest = { if (!welcomeUser) closeDialog() },
		title = {
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = titleArrangement,
				verticalAlignment = Alignment.CenterVertically
			) {
				if (quizTaken != null) {
					Icon(Icons.Rounded.LiveHelp, null, Modifier.padding(end = 14.dp))
				}
				Text(stringResource(title))
			}
		},
		text = { Text(stringResource(text), Modifier.verticalScroll(rememberScrollState())) },
		confirmButton = {
			Button(
				modifier = Modifier.fillMaxWidth(),
				onClick = {
					when {
						welcomeUser -> closeDialog()
						quizTaken == true -> reset(Actions.Reset)
					}
					closeDialog()
				},
				shape = MaterialTheme.shapes.medium
			) {
				Text(stringResource(buttonText))
			}
		}
	)
}

@Preview(showBackground = true)
@Composable
private fun InfoDialogPreview() {
	CapsuleTheme {
		Column(Modifier.fillMaxSize()) {
			InfoDialog(welcomeUser = true, reset = {}) {}
		}
	}
}