package com.roland.android.capsule.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.roland.android.capsule.R

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AppBar(
	title: String,
	homeScreen: Boolean = true,
	navigateUp: () -> Unit = {}
) {
	TopAppBar(
		title = { Text(title) },
		navigationIcon = {
			if (!homeScreen) {
				IconButton(onClick = navigateUp) {
					Icon(Icons.Rounded.ArrowBackIosNew, stringResource(R.string.back_icon_desc))
				}
			}
		}
	)
}