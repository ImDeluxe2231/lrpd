package com.example.foodike.presentation.onboarding

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.foodike.presentation.onboarding.components.BottomSection
import com.example.foodike.presentation.onboarding.components.OnboardingPage
import com.example.foodike.presentation.onboarding.util.OnBoardingItem
import com.example.foodike.presentation.util.Screen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoarding(
    navController: NavHostController,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.primary
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val context = LocalContext.current as Activity
            context.window.statusBarColor = MaterialTheme.colors.primary.toArgb()
            context.window.navigationBarColor = MaterialTheme.colors.primary.toArgb()

            val scope = rememberCoroutineScope()

            val items = OnBoardingItem.get()

            val pagerState = rememberPagerState()

            HorizontalPager(
                count = items.size,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.8f),
                state = pagerState,
            ) { page ->
                OnboardingPage(item = items[page])
            }
            Column(
                modifier = Modifier
                    .padding(0.dp, 0.dp, 0.dp, 16.dp)
                    .fillMaxSize()
                    .weight(0.2f),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BottomSection(size = items.size, index = pagerState.currentPage) {
                    if (pagerState.currentPage + 1 < items.size) {
                        scope.launch {
                            pagerState.scrollToPage(pagerState.currentPage + 1)
                        }

                    } else {
                        navController.navigate(Screen.LoginScreen.route)
                    }
                }
            }

        }
    }

}




