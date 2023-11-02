package com.roland.android.capsule.util

sealed interface Actions {
	object NextQuestion : Actions
	object PreviousQuestion : Actions
	data class SelectAnswer(val answer: String?) : Actions
	object Submit : Actions
	object Reset : Actions
}
