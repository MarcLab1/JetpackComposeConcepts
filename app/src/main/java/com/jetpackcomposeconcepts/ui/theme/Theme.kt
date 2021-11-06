package com.jetpackcomposeconcepts

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Blue800,
    primaryVariant = Blue700,
    secondary = Teal200,
    background = Black1,
    surface = Black1,
    onPrimary = White,
    onSecondary = White,
    onBackground = White,
    onSurface = White
)

private val LightColorPalette = lightColors(
    primary = Blue800,
    primaryVariant = Teal300,
    secondary = Teal300,
    background = White,
    surface = White,
    onPrimary = White,
    onSecondary = White,
    onBackground = Black1,
    onSurface = Black1

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun MyComposeNativeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}