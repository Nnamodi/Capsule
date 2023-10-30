package com.roland.android.capsule.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.roland.android.capsule.ui.screens.CapsuleTabs
import com.roland.android.capsule.ui.theme.CapsuleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			CapsuleTheme {
				CapsuleTabs()
			}
		}
	}
}