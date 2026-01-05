package com.example.foc.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foc.R
import com.example.foc.ui.theme.Greyscale300
import com.example.foc.ui.theme.Primary900
import com.example.foc.ui.theme.Spacing
import kotlinx.coroutines.launch

data class OnboardingPage(
    val title: String,
    val description: String,
    val imageRes: Int? = null
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
            imageRes = R.drawable.ic_logo // Replace with actual walkthrough images if available
        ),
        OnboardingPage(
            title = "Effortless Organization – All in One Place",
            description = "Easily categorize your work, stay organized, and conquer tasks with Focusify’s intuitive project and tag system.",
            imageRes = R.drawable.ic_logo
        ),
        OnboardingPage(
            title = "Track Your Progress & Visualize Your Success",
            description = "Track your productivity over time, gain insights, and level up your efficiency. It’s time to achieve your goals.",
            imageRes = R.drawable.ic_logo
        )
    )

    val pagerState = rememberPagerState(pageCount = { pages.size })
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(Spacing.Space24)
    ) {
        // Skip Button
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
            if (pagerState.currentPage < pages.size - 1) {
                TextButton(onClick = onSkip) {
                    Text(
                        text = stringResource(id = R.string.skip),
                        color = Primary900,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) { page ->
            OnboardingPageContent(pages[page])
        }

        // Bottom section
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Page Indicator
            Row(
                Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pages.size) { iteration ->
                    val color = if (pagerState.currentPage == iteration) Primary900 else Greyscale300
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(if (pagerState.currentPage == iteration) 24.dp else 8.dp, 8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(Spacing.Space24))

            // Primary CTA
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
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Primary900)
            ) {
                Text(
                    text = if (pagerState.currentPage < pages.size - 1) 
                        stringResource(id = R.string.continue_text) 
                    else 
                        stringResource(id = R.string.get_started),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun OnboardingPageContent(page: OnboardingPage) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Spacing.Space16),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Placeholder for illustration
        Box(
            modifier = Modifier
                .size(300.dp)
                .background(Color.Transparent),
            contentAlignment = Alignment.Center
        ) {
             Image(
                painter = painterResource(id = page.imageRes ?: R.drawable.ic_logo),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(Spacing.Space48))

        Text(
            text = page.title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(Spacing.Space16))

        Text(
            text = page.description,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
        )
    }
}
