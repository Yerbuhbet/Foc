package com.example.foc.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foc.R
import com.example.foc.ui.theme.Primary900
import com.example.foc.ui.theme.Spacing
import com.example.foc.ui.theme.Greyscale200

enum class NavbarVariant {
    Default,
    ProgressBar,
    NavbarFull,
    ProgressBarFull
}

@Composable
fun Navbar(
    variant: NavbarVariant = NavbarVariant.Default,
    title: String = "",
    showTitle: Boolean = true,
    showLeftIcon: Boolean = true,
    showRightIcon1: Boolean = false,
    showRightIcon2: Boolean = false,
    showRightIcon3: Boolean = false,
    showLogo: Boolean = false,
    showRightText: Boolean = false,
    rightText: String = "Continue",
    progress: Float = 0f, // 0 to 1
    stepNumber: String = "",
    onLeftIconClick: () -> Unit = {},
    onRightIcon1Click: () -> Unit = {},
    onRightIcon2Click: () -> Unit = {},
    onRightIcon3Click: () -> Unit = {},
    onRightTextClick: () -> Unit = {}
) {
    val isFullWidth = variant == NavbarVariant.NavbarFull || variant == NavbarVariant.ProgressBarFull
    val isDark = MaterialTheme.colorScheme.background != Color.White
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .padding(horizontal = Spacing.Space24, vertical = Spacing.Space12),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Left Section
        Box(modifier = Modifier.size(28.dp), contentAlignment = Alignment.CenterStart) {
            if (showLogo) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = "Logo",
                    tint = if (isDark) Color.White else Primary900,
                    modifier = Modifier.size(28.dp)
                )
            } else if (showLeftIcon) {
                IconButton(onClick = onLeftIconClick, modifier = Modifier.size(28.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_left),
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }

        // Middle Section (Title or Progress Bar)
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = Spacing.Space16),
            contentAlignment = Alignment.Center
        ) {
            if (variant == NavbarVariant.ProgressBar || variant == NavbarVariant.ProgressBarFull) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(12.dp)
                        .background(
                            if (isDark) Color(0xFF35383F) else Greyscale200,
                            RoundedCornerShape(100.dp)
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(progress)
                            .fillMaxHeight()
                            .background(Primary900, RoundedCornerShape(100.dp))
                    )
                }
            } else if (showTitle) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = if (isFullWidth && !isDark) Color.White else MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        // Right Section
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.widthIn(min = 28.dp)
        ) {
            if (stepNumber.isNotEmpty()) {
                Text(
                    text = stepNumber,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.End
                )
            } else if (showRightText) {
                TextButton(onClick = onRightTextClick) {
                    Text(
                        text = rightText,
                        color = Primary900,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
            } else {
                if (showRightIcon3) {
                    IconButton(onClick = onRightIcon3Click, modifier = Modifier.size(28.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_notification),
                            contentDescription = null,
                            tint = if (isFullWidth && !isDark) Color.White else MaterialTheme.colorScheme.onBackground
                        )
                    }
                    if (showRightIcon2 || showRightIcon1) Spacer(modifier = Modifier.width(Spacing.Space12))
                }
                if (showRightIcon2) {
                    IconButton(onClick = onRightIcon2Click, modifier = Modifier.size(28.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_notification),
                            contentDescription = null,
                            tint = if (isFullWidth && !isDark) Color.White else MaterialTheme.colorScheme.onBackground
                        )
                    }
                    if (showRightIcon1) Spacer(modifier = Modifier.width(Spacing.Space12))
                }
                if (showRightIcon1) {
                    IconButton(onClick = onRightIcon1Click, modifier = Modifier.size(28.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_notification),
                            contentDescription = null,
                            tint = if (isFullWidth && !isDark) Color.White else MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
                // Placeholder to keep balance
                if (!showRightIcon1 && !showRightIcon2 && !showRightIcon3 && !showRightText && stepNumber.isEmpty()) {
                    Spacer(modifier = Modifier.size(28.dp))
                }
            }
        }
    }
}
