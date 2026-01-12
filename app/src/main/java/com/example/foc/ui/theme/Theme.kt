package com.example.foc.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Variables.Primary.`900`,
    onPrimary = Variables.Others.White,
    secondary = Variables.Dark.`3`, // Neutral button background for dark theme
    onSecondary = Variables.Greyscale.`50`,
    tertiary = Variables.Greyscale.`700`,
    background = Variables.Dark.`1`,
    surface = Variables.Dark.`2`,
    onTertiary = Variables.Others.White,
    onBackground = Variables.Greyscale.`50`,
    onSurface = Variables.Greyscale.`50`,
)

private val LightColorScheme = lightColorScheme(
    primary = Variables.Primary.`900`,
    onPrimary = Variables.Others.White,
    secondary = Variables.Greyscale.`100`, // Neutral button background for light theme
    onSecondary = Variables.Greyscale.`900`,
    tertiary = Variables.Greyscale.`700`,
    background = Variables.Others.White,
    surface = Variables.Greyscale.`50`,
    onTertiary = Variables.Others.White,
    onBackground = Variables.Greyscale.`900`,
    onSurface = Variables.Greyscale.`900`,
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
