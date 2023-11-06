package com.roland.android.capsule.di

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.roland.android.capsule.R
import com.roland.android.capsule.util.Timing
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UtilityModule {

	@Provides
	@Singleton
	fun providesPlayer(@ApplicationContext context: Context): Player {
		val videoUri = "android.resource://${context.packageName}/${R.raw.video_file}"
		return ExoPlayer.Builder(context).build().apply {
			setMediaItem(MediaItem.fromUri(videoUri))
		}
	}

	@Provides
	@Singleton
	fun providesTiming() = Timing()
}