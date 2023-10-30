package com.roland.android.capsule.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.net.toUri
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.roland.android.capsule.R
import com.roland.android.capsule.ui.components.UpNextButton
import com.roland.android.capsule.ui.theme.CapsuleTheme

@Composable
fun VideoScreen(navigateToNextScreen: () -> Unit) {
	val context = LocalContext.current
	val videoUri = "".toUri()
	val player = remember {
		ExoPlayer.Builder(context).build().apply {
			setMediaItem(MediaItem.fromUri(videoUri))
			prepare()
		}
	}
	var lifecycle by remember {
		mutableStateOf(Lifecycle.Event.ON_CREATE)
	}
	val lifecycleOwner = LocalLifecycleOwner.current

	DisposableEffect(lifecycle) {
		val observer = LifecycleEventObserver { _, event ->
			lifecycle = event
		}
		lifecycleOwner.lifecycle.addObserver(observer)

		onDispose {
			lifecycleOwner.lifecycle.removeObserver(observer)
		}
	}

	Column(Modifier.fillMaxSize()) {
		Box(
			modifier = Modifier
				.fillMaxSize()
				.weight(1f),
			contentAlignment = Alignment.Center
		) {
			AndroidView(
				factory = { context ->
					PlayerView(context).also {
						it.player = player
					}
				},
				modifier = Modifier
					.fillMaxHeight(0.55f)
					.fillMaxWidth()
					.padding(horizontal = 20.dp),
				update = {
					when (lifecycle) {
						Lifecycle.Event.ON_PAUSE -> {
							it.onPause()
							it.player?.pause()
						}
						Lifecycle.Event.ON_RESUME -> it.onResume()
						else -> {}
					}
				}
			)
		}

		UpNextButton(
			modifier = Modifier.fillMaxWidth(),
			nextScreenTitle = R.string.notes,
			nextScreenDescription = R.string.notes_description,
			navigateToNextScreen = navigateToNextScreen
		)
	}
}

@Preview
@Composable
private fun VideoScreenPreview() {
	CapsuleTheme {
		VideoScreen {}
	}
}