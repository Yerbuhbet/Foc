package com.example.foc.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Primary900,
    secondary = Primary100,
    tertiary = Greyscale700,
    background = Dark1,
    surface = Dark2,
    onPrimary = White,
    onSecondary = Greyscale50,
    onTertiary = White,
    onBackground = Greyscale50,
    onSurface = Greyscale50,
)

private val LightColorScheme = lightColorScheme(
    primary = Primary900,
    secondary = Primary100,
    tertiary = Greyscale700,
    background = White,
    surface = Greyscale50,
    onPrimary = White,
    onSecondary = Greyscale900,
    onTertiary = White,
    onBackground = Greyscale900,
    onSurface = Greyscale900,
)

@Composable
fun FocTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
