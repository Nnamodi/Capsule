package com.roland.android.capsule.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.roland.android.capsule.R

@Composable
fun UpNextButton(
	modifier: Modifier,
	@StringRes nextScreenTitle: Int,
	@StringRes nextScreenDescription: Int? = null,
	navigateToNextScreen: () -> Unit
) {
	Column(modifier.padding(20.dp)) {
		nextScreenDescription?.let {
			Text(stringResource(R.string.up_next))
		}
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(top = 10.dp)
				.clip(MaterialTheme.shapes.medium)
				.background(MaterialTheme.colorScheme.primary)
				.clickable { navigateToNextScreen() }
				.padding(horizontal = 20.dp, vertical = 10.dp),
			verticalAlignment = Alignment.CenterVertically
		) {
			Column(
				modifier = Modifier.weight(1f),
				verticalArrangement = Arrangement.SpaceAround
			) {
				Text(
					text = stringResource(nextScreenTitle),
					modifier = Modifier.padding(vertical = 10.dp),
					color = MaterialTheme.colorScheme.onPrimary,
					fontWeight = FontWeight.Bold
				)
				nextScreenDescription?.let {
					Text(
						text = stringResource(nextScreenDescription),
						color = MaterialTheme.colorScheme.onPrimary,
						modifier = Modifier.padding(bottom = 10.dp)
					)
				}
			}
			Icon(
				imageVector = Icons.Rounded.ArrowForwardIos,
				contentDescription = null,
				tint = MaterialTheme.colorScheme.onPrimary
			)
		}
	}
}

@Composable
fun CustomIconButton(
	onClick: () -> Unit,
	clipStart: Boolean = true,
	clipEnd: Boolean = true,
	contentDescription: String,
	icon: ImageVector,
	enabled: Boolean = true
) {
	val clipModifier = when {
		clipStart && clipEnd -> Modifier.clip(MaterialTheme.shapes.medium)
		clipStart -> Modifier.clip(RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp))
		clipEnd -> Modifier.clip(RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp))
		else -> Modifier
	}
	val backgroundTint = if (enabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline

	Box(
		modifier = Modifier
			.then(clipModifier)
			.background(backgroundTint)
			.clickable(enabled) { onClick() }
	) {
		Icon(
			imageVector = icon,
			contentDescription = contentDescription,
			modifier = Modifier.padding(10.dp),
			tint = MaterialTheme.colorScheme.onPrimary
		)
	}
}