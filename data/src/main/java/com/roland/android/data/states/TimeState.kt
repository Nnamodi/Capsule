package com.roland.android.data.states

import com.roland.android.data.util.Constant.ALLOTTED_TIME_MILLIS
import com.roland.android.data.util.Constant.START_TIME

data class TimeState(
	val formattedTime: String = START_TIME,
	val timeInMillis: Long = ALLOTTED_TIME_MILLIS,
	val timeUp: Boolean = false
)
