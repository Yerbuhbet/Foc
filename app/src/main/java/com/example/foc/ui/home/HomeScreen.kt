package com.example.foc.ui.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foc.R
import com.example.foc.model.Task
import com.example.foc.ui.theme.*

@Composable
fun HomeScreen(viewModel: PomodoroViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
        ) {
            // Header background
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(BrandPrimary)
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HomeHeader()
                Spacer(modifier = Modifier.height(24.dp))
                TaskSelector(uiState.selectedTask)
                Spacer(modifier = Modifier.height(32.dp))
                PomodoroTimer(uiState.timeLeft, uiState.progress)
                Spacer(modifier = Modifier.height(48.dp))
                FocusButton(uiState.isRunning) { viewModel.toggleTimer() }
                Spacer(modifier = Modifier.height(32.dp))
                ModeSelection()
            }
        }
    }
}

@Composable
fun HomeHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Logo",
            tint = Color.White,
            modifier = Modifier.size(28.dp)
        )
        Text(
            text = stringResource(id = R.string.app_name),
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notifications",
                tint = Color.White,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@Composable
fun TaskSelector(selectedTask: Task?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceGrey)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 18.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = selectedTask?.name ?: stringResource(id = R.string.select_task),
                color = TextGreyLight,
                fontSize = 18.sp
            )
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowDown,
                contentDescription = "Dropdown",
                tint = TextGreyLight
            )
        }
    }
}

@Composable
fun PomodoroTimer(timeLeft: Long, progress: Float) {
    val minutes = (timeLeft / 1000) / 60
    val seconds = (timeLeft / 1000) % 60
    val timeText = String.format("%02d:%02d", minutes, seconds)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(348.dp)
            .shadow(50.dp, CircleShape, spotColor = Color(0x2904060F))
            .background(Color.White, CircleShape)
            .padding(24.dp)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawArc(
                color = Color(0xFFF5F5F5),
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = 12.dp.toPx(), cap = StrokeCap.Round)
            )
            drawArc(
                color = BrandPrimary,
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
                color = TextLight
            )
            Text(
                text = stringResource(id = R.string.no_sessions),
                fontSize = 18.sp,
                color = TextGrey,
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
        colors = ButtonDefaults.buttonColors(containerColor = BrandPrimary),
        shape = RoundedCornerShape(1000.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = null,
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = if (isRunning) stringResource(id = R.string.pause) else stringResource(id = R.string.start_to_focus),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun ModeSelection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ModeItem(icon = R.drawable.ic_loading, label = stringResource(id = R.string.strict_mode))
        ModeItem(icon = R.drawable.ic_loading, label = stringResource(id = R.string.timer_mode))
        ModeItem(icon = R.drawable.ic_loading, label = stringResource(id = R.string.white_noise))
    }
}

@Composable
fun ModeItem(icon: Int, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = label,
            tint = TextGrey,
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            fontSize = 12.sp,
            color = TextGrey,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color.White,
        modifier = Modifier.shadow(8.dp)
    ) {
        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = { Icon(Icons.Default.PlayArrow, contentDescription = stringResource(id = R.string.pomodoro)) },
            label = { Text(stringResource(id = R.string.pomodoro)) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = BrandPrimary,
                selectedTextColor = BrandPrimary,
                unselectedIconColor = TextGreyLight,
                unselectedTextColor = TextGreyLight,
                indicatorColor = Color.White
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.PlayArrow, contentDescription = stringResource(id = R.string.manage)) },
            label = { Text(stringResource(id = R.string.manage)) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.PlayArrow, contentDescription = stringResource(id = R.string.calendar)) },
            label = { Text(stringResource(id = R.string.calendar)) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.PlayArrow, contentDescription = stringResource(id = R.string.report)) },
            label = { Text(stringResource(id = R.string.report)) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.PlayArrow, contentDescription = stringResource(id = R.string.settings)) },
            label = { Text(stringResource(id = R.string.settings)) }
        )
    }
}
