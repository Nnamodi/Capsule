package com.roland.android.capsule.util

sealed class Actions {
	object NextQuestion : Actions()
	object PreviousQuestion : Actions()
}
