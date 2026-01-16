package com.example.foc.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Colors.Primary.`900`,
    onPrimary = Colors.Others.White,
    secondary = Colors.Dark.`3`, // Neutral button background for dark theme
    onSecondary = Colors.Greyscale.`50`,
    tertiary = Colors.Greyscale.`700`,
    background = Colors.Dark.`1`,
    surface = Colors.Dark.`2`,
    onTertiary = Colors.Others.White,
    onBackground = Colors.Greyscale.`50`,
    onSurface = Colors.Greyscale.`50`,
)

private val LightColorScheme = lightColorScheme(
    primary = Colors.Primary.`900`,
    onPrimary = Colors.Others.White,
    secondary = Colors.Greyscale.`100`, // Neutral button background for light theme
    onSecondary = Colors.Greyscale.`900`,
    tertiary = Colors.Greyscale.`700`,
    background = Colors.Others.White,
    surface = Colors.Greyscale.`50`,
    onTertiary = Colors.Others.White,
    onBackground = Colors.Greyscale.`900`,
    onSurface = Colors.Greyscale.`900`,
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
