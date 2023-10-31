package com.roland.android.capsule.ui.screens

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
import androidx.compose.ui.res.stringResource
import com.roland.android.capsule.R
import com.roland.android.capsule.data.UiState
import com.roland.android.capsule.ui.theme.light_outline
import com.roland.android.capsule.util.Actions
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Capsule(uiState: UiState, actions: (Actions) -> Unit) {
	Scaffold(
		topBar = {
			TopAppBar(title = { Text(stringResource(R.string.app_name)) })
		}
	) {
		Column(Modifier.padding(it)) {
			val capsuleTabs = CapsuleTabs.values()
			val scope = rememberCoroutineScope()
			val pagerState = rememberPagerState(0)
			val scrollToPage: (Int?) -> Unit = { index ->
				val nextPage = pagerState.currentPage + 1
				scope.launch { pagerState.animateScrollToPage(index ?: nextPage) }
			}

			TabRow(selectedTabIndex = pagerState.currentPage) {
				capsuleTabs.forEachIndexed { index, tab ->
					Tab(
						text = { Text(stringResource(tab.nameRes)) },
						selected = pagerState.currentPage >= index,
						onClick = { scrollToPage(index) },
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
					2 -> QuizScreen(uiState, actions)
					3 -> ResultScreen()
					else -> {}
				}
			}
		}
	}
}

private enum class CapsuleTabs(val nameRes: Int) {
	Video(R.string.video),
	Notes(R.string.notes),
	Quiz(R.string.quiz),
	QuizResult(R.string.quiz_result)
}