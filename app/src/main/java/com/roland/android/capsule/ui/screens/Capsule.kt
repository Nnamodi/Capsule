package com.roland.android.capsule.ui.screens

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.roland.android.capsule.R
import com.roland.android.capsule.data.UiState
import com.roland.android.capsule.ui.components.Clock
import com.roland.android.capsule.ui.dialog.TimeUpDialog
import com.roland.android.capsule.ui.theme.light_outline
import com.roland.android.capsule.util.Actions
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Capsule(uiState: UiState, actions: (Actions) -> Unit) {
	val context = LocalContext.current
	val capsuleTabs = CapsuleTabs.values()
	val scope = rememberCoroutineScope()
	val pagerState = rememberPagerState(0)
	val scrollToPage: (Int?) -> Unit = { index ->
		val nextPage = pagerState.currentPage + 1
		scope.launch { pagerState.animateScrollToPage(index ?: nextPage) }
	}

	Scaffold(
		topBar = {
			TopAppBar(
				title = { Text(stringResource(R.string.app_name)) },
				actions = { Clock(uiState.time) }
			)
		}
	) { paddingValues ->
		Column(Modifier.padding(paddingValues)) {
			TabRow(selectedTabIndex = pagerState.currentPage) {
				capsuleTabs.forEachIndexed { index, tab ->
					Tab(
						text = { Text(stringResource(tab.nameRes)) },
						selected = pagerState.currentPage >= index || uiState.result != null,
						onClick = {
							if (index > (pagerState.currentPage + 1) && !uiState.quizHalfFinished) {
								Toast.makeText(context, context.getString(R.string.one_at_a_time), Toast.LENGTH_SHORT).show()
								return@Tab
							}
							scrollToPage(index)
						},
						unselectedContentColor = light_outline
					)
				}
			}
			HorizontalPager(
				state = pagerState,
				pageCount = capsuleTabs.size,
				beyondBoundsPageCount = capsuleTabs.size,
			) { page ->
				when (page) {
					0 -> VideoScreen { scrollToPage(null) }
					1 -> NotesScreen { scrollToPage(null) }
					2 -> QuizScreen(uiState, actions) { scrollToPage(it) }
					3 -> ResultScreen(uiState) { actions(it); scrollToPage(0) }
					else -> {}
				}
			}

			if (pagerState.currentPage > 0) {
				val currentQuestionId = uiState.currentQuestion.id
				val previousPage = pagerState.currentPage - 1

				BackHandler {
					if (currentQuestionId > 0 && pagerState.currentPage == 2) {
						actions(Actions.PreviousQuestion)
					} else scrollToPage(previousPage)
				}
			}
		}

		if (uiState.time.timeUp) {
			TimeUpDialog(
				quizHalfFinished = uiState.quizHalfFinished,
				action = { actions(it) },
				navigateToFirstScreen = { scrollToPage(0) },
				navigateToResultScreen = { scrollToPage(capsuleTabs.lastIndex) }
			)
		}
	}
}

private enum class CapsuleTabs(val nameRes: Int) {
	Video(R.string.video),
	Notes(R.string.notes),
	Quiz(R.string.quiz),
	QuizResult(R.string.quiz_result)
}