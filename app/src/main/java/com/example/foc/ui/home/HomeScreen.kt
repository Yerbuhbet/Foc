package com.example.foc.ui.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foc.R
import com.example.foc.model.Task
import com.example.foc.ui.components.Navbar
import com.example.foc.ui.components.NavbarVariant
import com.example.foc.ui.theme.CornerRadius
import com.example.foc.ui.theme.Spacing
import com.example.foc.ui.theme.Variables

@Composable
fun HomeScreen(
    viewModel: PomodoroViewModel,
    onToggleTheme: () -> Unit,
    onResetOnboarding: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
        ) {
            // Header background (Primary 900)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Variables.Primary.`900`)
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Navbar(
                    variant = NavbarVariant.NavbarFull,
                    title = stringResource(id = R.string.app_name),
                    showLogo = true,
                    showLeftIcon = false,
                    showRightIcon1 = true,
                    onRightIcon1Click = { /* Handle notification */ }
                )

                // Debug Buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Spacing.Space24),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = onToggleTheme,
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
                    ) {
                        Text("Toggle Theme", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSecondary)
                    }
                    Button(
                        onClick = onResetOnboarding,
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
                    ) {
                        Text("Reset App", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSecondary)
                    }
                }

                Spacer(modifier = Modifier.height(Spacing.Space24))
                TaskSelector(uiState.selectedTask)
                Spacer(modifier = Modifier.height(Spacing.Space32))
                PomodoroTimer(uiState.timeLeft, uiState.progress)
                Spacer(modifier = Modifier.height(Spacing.Space48))
                FocusButton(uiState.isRunning) { viewModel.toggleTimer() }
                Spacer(modifier = Modifier.height(Spacing.Space32))
                ModeSelection()
            }
        }
    }
}

@Composable
fun HomeHeader() {
    // Removed as it's replaced by Navbar
}

@Composable
fun TaskSelector(selectedTask: Task?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Spacing.Space24),
        shape = RoundedCornerShape(CornerRadius.Radius10),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = Spacing.Space20, vertical = Spacing.Space18)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = selectedTask?.name ?: stringResource(id = R.string.select_task),
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                fontSize = 18.sp
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = "Dropdown",
                tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun PomodoroTimer(timeLeft: Long, progress: Float) {
    val minutes = (timeLeft / 1000) / 60
    val seconds = (timeLeft / 1000) % 60
    val timeText = String.format("%02d:%02d", minutes, seconds)
    val isLightTheme = MaterialTheme.colorScheme.background == Variables.Others.White

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(348.dp)
            .shadow(50.dp, CircleShape, spotColor = Color(0x2904060F))
            .background(MaterialTheme.colorScheme.surface, CircleShape)
            .padding(Spacing.Space24)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawArc(
                color = if (isLightTheme) Variables.Greyscale.`100` else Variables.Dark.`3`,
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = 12.dp.toPx(), cap = StrokeCap.Round)
            )
            drawArc(
                color = Variables.Primary.`900`,
                startAngle = -90f,
                sweepAngle = 360f * progress,
                useCenter = false,
                style = Stroke(width = 12.dp.toPx(), cap = StrokeCap.Round)
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = timeText,
                fontSize = 64.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = stringResource(id = R.string.no_sessions),
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                letterSpacing = 0.2.sp
            )
        }
    }
}

@Composable
fun FocusButton(isRunning: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(200.dp)
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Variables.Primary.`900`),
        shape = RoundedCornerShape(1000.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = null,
                tint = Variables.Others.White,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(Spacing.Space16))
            Text(
                text = if (isRunning) stringResource(id = R.string.pause) else stringResource(id = R.string.start_to_focus),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Variables.Others.White
            )
        }
    }
}

@Composable
fun ModeSelection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Spacing.Space24),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ModeItem(icon = R.drawable.ic_logo, label = stringResource(id = R.string.strict_mode))
        ModeItem(icon = R.drawable.ic_logo, label = stringResource(id = R.string.timer_mode))
        ModeItem(icon = R.drawable.ic_logo, label = stringResource(id = R.string.white_noise))
    }
}

@Composable
fun ModeItem(icon: Int, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = label,
            tint = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.height(Spacing.Space8))
        Text(
            text = label,
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.shadow(Spacing.Space8)
    ) {
        val selectedColor = Variables.Primary.`900`
        val unselectedColor = Variables.Greyscale.`500`

        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = { Icon(Icons.Default.PlayArrow, contentDescription = stringResource(id = R.string.pomodoro)) },
            label = { Text(stringResource(id = R.string.pomodoro)) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                selectedTextColor = selectedColor,
                unselectedIconColor = unselectedColor,
                unselectedTextColor = unselectedColor,
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.PlayArrow, contentDescription = stringResource(id = R.string.manage)) },
            label = { Text(stringResource(id = R.string.manage)) },
            colors = NavigationBarItemDefaults.colors(
                unselectedIconColor = unselectedColor,
                unselectedTextColor = unselectedColor
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.PlayArrow, contentDescription = stringResource(id = R.string.calendar)) },
            label = { Text(stringResource(id = R.string.calendar)) },
            colors = NavigationBarItemDefaults.colors(
                unselectedIconColor = unselectedColor,
                unselectedTextColor = unselectedColor
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.PlayArrow, contentDescription = stringResource(id = R.string.report)) },
            label = { Text(stringResource(id = R.string.report)) },
            colors = NavigationBarItemDefaults.colors(
                unselectedIconColor = unselectedColor,
                unselectedTextColor = unselectedColor
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.PlayArrow, contentDescription = stringResource(id = R.string.settings)) },
            label = { Text(stringResource(id = R.string.settings)) },
            colors = NavigationBarItemDefaults.colors(
                unselectedIconColor = unselectedColor,
                unselectedTextColor = unselectedColor
            )
        )
    }
}
