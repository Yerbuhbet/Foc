package com.example.foc.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foc.R
import com.example.foc.ui.theme.Spacing
import com.example.foc.ui.theme.Variables
import kotlinx.coroutines.launch

data class OnboardingPage(
    val title: String,
    val description: String,
    val imageResLight: Int,
    val imageResDark: Int
)

@Composable
fun OnboardingScreen(
    onFinished: () -> Unit,
    onSkip: () -> Unit
) {
    val pages = listOf(
        OnboardingPage(
            title = "Your Ultimate Pomodoro Productivity Assistant",
            description = "Focusify helps you stay on track, manage tasks, and work efficiently. Let’s get started with Focusify right now!",
            imageResLight = R.drawable.wt_1,
            imageResDark = R.drawable.wtb_1
        ),
        OnboardingPage(
            title = "Effortless Organization – All in One Place",
            description = "Easily categorize your work, stay organized, and conquer tasks with Focusify’s intuitive project and tag system.",
            imageResLight = R.drawable.wt_2,
            imageResDark = R.drawable.wtb_2
        ),
        OnboardingPage(
            title = "Track Your Progress & Visualize Your Success",
            description = "Track your productivity over time, gain insights, and level up your efficiency. It’s time to achieve your goals.",
            imageResLight = R.drawable.wt_3,
            imageResDark = R.drawable.wtb_3
        )
    )

    val pagerState = rememberPagerState(pageCount = { pages.size })
    val scope = rememberCoroutineScope()
    val isDark = isSystemInDarkTheme()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) { page ->
            OnboardingPageContent(pages[page], isDark)
        }

        // Bottom section (Fixed height to prevent shifting)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Spacing.Space24, vertical = Spacing.Space32)
        ) {
            // Page Indicator
            Row(
                Modifier
                    .height(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pages.size) { iteration ->
                    val color = if (pagerState.currentPage == iteration) Variables.Primary.`900` else Variables.Greyscale.`300`
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(if (pagerState.currentPage == iteration) 24.dp else 8.dp, 8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(Spacing.Space32))

            // Two Buttons implementation from Figma
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Secondary Button (Skip or Back)
                Button(
                    onClick = {
                        if (pagerState.currentPage > 0) {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage - 1)
                            }
                        } else {
                            onSkip()
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = MaterialTheme.colorScheme.onSecondary
                    ),
                    shape = RoundedCornerShape(1000.dp)
                ) {
                    Text(
                        text = if (pagerState.currentPage == 0) stringResource(id = R.string.skip) else stringResource(id = R.string.back),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Primary Button (Continue or Get Started)
                Button(
                    onClick = {
                        if (pagerState.currentPage < pages.size - 1) {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        } else {
                            onFinished()
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    shape = RoundedCornerShape(1000.dp)
                ) {
                    Text(
                        text = if (pagerState.currentPage < pages.size - 1)
                            stringResource(id = R.string.continue_text)
                        else
                            stringResource(id = R.string.get_started),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun OnboardingPageContent(page: OnboardingPage, isDark: Boolean) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image Stacking Order (Top -> Bottom)
        // 1. Subtract.xml (top-most)
        // 2. Picture inside (WT_x or WTB_x)
        // 3. Android.png
        // 4. Ellipse.xml (bottom-most shadow)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.2f),
            contentAlignment = Alignment.BottomCenter
        ) {
            // 4. Subtract.xml (Background) - Lowest layer in Box
            Image(
                painter = painterResource(id = R.drawable.subtract),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(MaterialTheme.colorScheme.surface)
            )

            // 3. Ellipse.xml (Shadow)
            Image(
                painter = painterResource(id = R.drawable.ellipse),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .align(Alignment.BottomCenter),
                contentScale = ContentScale.FillWidth
            )

            // 2. WT_x (Picture inside)
            Image(
                painter = painterResource(id = if (isDark) page.imageResDark else page.imageResLight),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight(0.82f)
                    .padding(bottom = 38.dp) // Fine-tuned to fit inside the Android.png frame
                    .padding(horizontal = 48.dp),
                contentScale = ContentScale.Fit
            )

            // 1. Android.png (Phone Frame) - On top of the picture
            Image(
                painter = painterResource(id = R.drawable.android),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight(0.85f)
                    .padding(bottom = 20.dp),
                contentScale = ContentScale.Fit
            )
        }

        // Text Section
        Column(
            modifier = Modifier
                .weight(0.8f)
                .padding(horizontal = Spacing.Space24),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(Spacing.Space24))
            
            Text(
                text = page.title,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground,
                lineHeight = 36.sp
            )

            Spacer(modifier = Modifier.height(Spacing.Space16))

            Text(
                text = page.description,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f),
                lineHeight = 24.sp
            )
        }
    }
}
