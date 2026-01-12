package com.example.foc.ui.theme

import androidx.compose.ui.graphics.Color

object Variables {
    object Primary {
        val `50` = Color(0xFFFFEFED)
        val `100` = Color(0xFFFFE0DA)
        val `200` = Color(0xFFFFD0C8)
        val `300` = Color(0xFFFFC1B5)
        val `400` = Color(0xFFFFB1A3)
        val `500` = Color(0xFFFFA191)
        val `600` = Color(0xFFFF927E)
        val `700` = Color(0xFFFF826C)
        val `800` = Color(0xFFFF7359)
        val `900` = Color(0xFFFF6347)
    }

    object Secondary {
        val `50` = Color(0xFFFFECE6)
        val `100` = Color(0xFFFFDACC)
        val `200` = Color(0xFFFFC7B3)
        val `300` = Color(0xFFFFB599)
        val `400` = Color(0xFFFFA280)
        val `500` = Color(0xFFFF8F66)
        val `600` = Color(0xFFFF7D4D)
        val `700` = Color(0xFFFF6A33)
        val `800` = Color(0xFFFF581A)
        val `900` = Color(0xFFFF4500)
    }

    object AlertsStatus {
        val Success = Color(0xFF12D18E)
        val Info = Color(0xFFFF6347)
        val Warning = Color(0xFFFACC15)
        val Error = Color(0xFFF75555)
        val LightDisabled = Color(0xFFD8D8D8)
        val DarkDisabled = Color(0xFF23252B)
        val ButtonDisabled = Color(0xFFCC4F39)
    }

    object Greyscale {
        val `50` = Color(0xFFFAFAFA)
        val `100` = Color(0xFFF5F5F5)
        val `200` = Color(0xFFEEEEEE)
        val `300` = Color(0xFFE0E0E0)
        val `400` = Color(0xFFBDBDBD)
        val `500` = Color(0xFF9E9E9E)
        val `600` = Color(0xFF757575)
        val `700` = Color(0xFF616161)
        val `800` = Color(0xFF424242)
        val `900` = Color(0xFF212121)
    }

    object Others {
        val White = Color(0xFFFFFFFF)
        val Black = Color(0xFF000000)
        val Red = Color(0xFFF54336)
        val Pink = Color(0xFFEA1E61)
        val Purple = Color(0xFF9D28AC)
        val DeepPurple = Color(0xFF673AB3)
        val Indigo = Color(0xFF3F51B2)
        val Blue = Color(0xFF1A96F0)
        val LightBlue = Color(0xFF00A9F1)
        val Cyan = Color(0xFF00BCD3)
        val Teal = Color(0xFF009689)
        val Green = Color(0xFF4AAF57)
        val LightGreen = Color(0xFF8BC255)
        val Lime = Color(0xFFCDDC4C)
        val Yellow = Color(0xFFFFEB4F)
        val Amber = Color(0xFFFFC02D)
        val Orange = Color(0xFFFF981F)
        val DeepOrange = Color(0xFFFF5726)
        val Brown = Color(0xFF7A5548)
        val BlueGrey = Color(0xFF607D8A)
    }

    object Dark {
        val `1` = Color(0xFF181A20)
        val `2` = Color(0xFF1E2025)
        val `3` = Color(0xFF1F222A)
        val `4` = Color(0xFF262A35)
        val `5` = Color(0xFF35383F)
    }

    object Background {
        val Teal = Color(0xFFEDF7F6)
        val Purple = Color(0xFFF7ECFF)
        val Red = Color(0xFFFFEFEE)
        val Blue = Color(0xFFEDF2FF)
        val Green = Color(0xFFEFF9F5)
        val Brown = Color(0xFFF8F3F1)
        val Yellow = Color(0xFFFFFCEB)
        val Orange = Color(0xFFFFF3F0)
        val Grey = Color(0xFFF6F6F6)
    }

    object Transparent {
        val Teal = Color(0x151A998E)
        val Purple = Color(0x159610FF)
        val Red = Color(0x15FE3323)
        val Blue = Color(0x15235DFF)
        val Green = Color(0x1534B27D)
        val Brown = Color(0x15A4634D)
        val Yellow = Color(0x15FFD300)
        val Orange = Color(0x15FF6347)
        val Grey = Color(0x15757575)
    }
}

object Brand {
    val Primary = Variables.Primary.`900`
    val Secondary = Variables.Primary.`100`
    val Orange = Variables.Primary.`900`
}

object Text {
    val Light = Variables.Greyscale.`900`
    val Grey = Variables.Greyscale.`700`
    val GreyLight = Variables.Greyscale.`50`
}

object Surface {
    val Light = Variables.Others.White
    val Grey = Variables.Greyscale.`50`
}

// Primary
val Primary50 = Variables.Primary.`50`
val Primary100 = Variables.Primary.`100`
val Primary200 = Variables.Primary.`200`
val Primary300 = Variables.Primary.`300`
val Primary400 = Variables.Primary.`400`
val Primary500 = Variables.Primary.`500`
val Primary600 = Variables.Primary.`600`
val Primary700 = Variables.Primary.`700`
val Primary800 = Variables.Primary.`800`
val Primary900 = Variables.Primary.`900`

// Secondary
val Secondary50 = Variables.Secondary.`50`
val Secondary100 = Variables.Secondary.`100`
val Secondary200 = Variables.Secondary.`200`
val Secondary300 = Variables.Secondary.`300`
val Secondary400 = Variables.Secondary.`400`
val Secondary500 = Variables.Secondary.`500`
val Secondary600 = Variables.Secondary.`600`
val Secondary700 = Variables.Secondary.`700`
val Secondary800 = Variables.Secondary.`800`
val Secondary900 = Variables.Secondary.`900`

// Alerts & Status
val Success = Variables.AlertsStatus.Success
val Info = Variables.AlertsStatus.Info
val Warning = Variables.AlertsStatus.Warning
val Error = Variables.AlertsStatus.Error
val LightDisabled = Variables.AlertsStatus.LightDisabled
val DarkDisabled = Variables.AlertsStatus.DarkDisabled
val ButtonDisabled = Variables.AlertsStatus.ButtonDisabled

// Greyscale
val Greyscale50 = Variables.Greyscale.`50`
val Greyscale100 = Variables.Greyscale.`100`
val Greyscale200 = Variables.Greyscale.`200`
val Greyscale300 = Variables.Greyscale.`300`
val Greyscale400 = Variables.Greyscale.`400`
val Greyscale500 = Variables.Greyscale.`500`
val Greyscale600 = Variables.Greyscale.`600`
val Greyscale700 = Variables.Greyscale.`700`
val Greyscale800 = Variables.Greyscale.`800`
val Greyscale900 = Variables.Greyscale.`900`

// Others
val White = Variables.Others.White
val Black = Variables.Others.Black
val Red = Variables.Others.Red
val Pink = Variables.Others.Pink
val Purple = Variables.Others.Purple
val DeepPurple = Variables.Others.DeepPurple
val Indigo = Variables.Others.Indigo
val Blue = Variables.Others.Blue
val LightBlue = Variables.Others.LightBlue
val Cyan = Variables.Others.Cyan
val Teal = Variables.Others.Teal
val Green = Variables.Others.Green
val LightGreen = Variables.Others.LightGreen
val Lime = Variables.Others.Lime
val Yellow = Variables.Others.Yellow
val Amber = Variables.Others.Amber
val Orange = Variables.Others.Orange
val DeepOrange = Variables.Others.DeepOrange
val Brown = Variables.Others.Brown
val BlueGrey = Variables.Others.BlueGrey

// Dark
val Dark1 = Variables.Dark.`1`
val Dark2 = Variables.Dark.`2`
val Dark3 = Variables.Dark.`3`
val Dark4 = Variables.Dark.`4`
val Dark5 = Variables.Dark.`5`

// Background
val BackgroundTeal = Variables.Background.Teal
val BackgroundPurple = Variables.Background.Purple
val BackgroundRed = Variables.Background.Red
val BackgroundBlue = Variables.Background.Blue
val BackgroundGreen = Variables.Background.Green
val BackgroundBrown = Variables.Background.Brown
val BackgroundYellow = Variables.Background.Yellow
val BackgroundOrange = Variables.Background.Orange
val BackgroundGrey = Variables.Background.Grey

// Transparent (using alpha)
val TransparentTeal = Variables.Transparent.Teal
val TransparentPurple = Variables.Transparent.Purple
val TransparentRed = Variables.Transparent.Red
val TransparentBlue = Variables.Transparent.Blue
val TransparentGreen = Variables.Transparent.Green
val TransparentBrown = Variables.Transparent.Brown
val TransparentYellow = Variables.Transparent.Yellow
val TransparentOrange = Variables.Transparent.Orange
val TransparentGrey = Variables.Transparent.Grey

// Legacy compatibility
val BrandPrimary = Brand.Primary
val BrandSecondary = Brand.Secondary
val BrandOrange = Brand.Orange // Added for compatibility with Splash
val TextLight = Text.Light
val TextGrey = Text.Grey
val TextGreyLight = Text.GreyLight
val SurfaceLight = Surface.Light
val SurfaceGrey = Surface.Grey
val StrokeGrey = Variables.Greyscale.`200`
val AbsoluteWhite = Variables.Others.White
