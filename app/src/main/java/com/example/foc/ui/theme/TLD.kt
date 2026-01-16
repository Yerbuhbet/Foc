package com.example.foc.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object TLD {

    object Text {
        object General {
            val brand: Color @Composable get() = Colors.Primary.`900`
            val white: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.Black else Colors.Others.White
            val black: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Others.Black
            val textLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Greyscale.`900`
            val textDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`900` else Colors.Others.White
        }

        object Greyscale {
            val `900`: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`50` else Colors.Greyscale.`900`
            val `800`: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`100` else Colors.Greyscale.`800`
            val `700`: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`200` else Colors.Greyscale.`700`
            val `600`: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`300` else Colors.Greyscale.`600`
            val `500`: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`400` else Colors.Greyscale.`500`
            val `400`: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`500` else Colors.Greyscale.`400`
            val `300`: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`600` else Colors.Greyscale.`300`
            val `200`: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`700` else Colors.Greyscale.`200`
            val `100`: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`800` else Colors.Greyscale.`100`
            val `50`: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`900` else Colors.Greyscale.`50`
        }

        object AlertsAndStatus {
            val success: Color @Composable get() = Colors.AlertsStatus.Success
            val info: Color @Composable get() = Colors.AlertsStatus.Info
            val warning: Color @Composable get() = Colors.AlertsStatus.Warning
            val error: Color @Composable get() = Colors.AlertsStatus.Error
        }

        object Components {
            val textFilled: Color @Composable get() = Colors.Others.White
            val searchTextLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`600` else Colors.Greyscale.`400`
            val searchTextDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`400` else Colors.Greyscale.`600`
            val menubarText500: Color @Composable get() = Colors.Greyscale.`500`
            val textformDefault500: Color @Composable get() = Colors.Greyscale.`500`
            val textformDisabled600: Color @Composable get() = Colors.Greyscale.`600`
            object SeatAvailable {
                val light: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Primary.`600`
                val dark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Primary.`600` else Colors.Others.White
            }
            object MenubarSelected {
                val light: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Primary.`900`
                val dark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Primary.`900` else Colors.Others.White
            }
        }

        object Buttons {
            val brand: Color @Composable get() = Colors.Primary.`900`
            val brandLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Primary.`900`
            val whiteDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Primary.`900` else Colors.Others.White
            val white: Color @Composable get() = Colors.Others.White
            val greyscale900: Color @Composable get() = Colors.Greyscale.`900`
            object SocialMedia {
                val light: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Greyscale.`900`
                val dark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`900` else Colors.Others.White
            }
        }

        object InputForm2 {
            val inputformDefaultLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`700` else Colors.Greyscale.`400`
            val inputformReadOnlyLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`500` else Colors.Greyscale.`700`
            val inputformDisabledLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`700` else Colors.Greyscale.`500`
            val inputformDefaultDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`400` else Colors.Greyscale.`700`
            val inputformReadOnlyDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`700` else Colors.Greyscale.`500`
            val inputformDisabledDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`500` else Colors.Greyscale.`700`
        }

        object Tag {
            val tagSolidDefault600: Color @Composable get() = Colors.Greyscale.`600`
            val tagInvertedDefaultLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`300` else Colors.Greyscale.`600`
            val tagInvertedDefaultDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`600` else Colors.Greyscale.`300`
        }

        object Additionals {
            val absoluteBrand: Color @Composable get() = Colors.Primary.`900`
            val absoluteWhite: Color @Composable get() = Colors.Others.White
            val absolute900: Color @Composable get() = Colors.Greyscale.`900`
            val lightBrand: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Primary.`900`
            val darkBrand: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Primary.`900` else Colors.Others.White
        }
    }

    object Surface {
        object General {
            val brand: Color @Composable get() = Colors.Primary.`900`
            val white: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.Black else Colors.Others.White
            val black: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Others.Black
            val surfaceLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Greyscale.`900`
            val surfaceDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`900` else Colors.Others.White
        }

        object Greyscale {
            val `900`: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`50` else Colors.Greyscale.`900`
            val `800`: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`100` else Colors.Greyscale.`800`
            val `700`: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`200` else Colors.Greyscale.`700`
            val `600`: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`300` else Colors.Greyscale.`600`
            val `500`: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`400` else Colors.Greyscale.`500`
            val `400`: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`500` else Colors.Greyscale.`400`
            val `300`: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`600` else Colors.Greyscale.`300`
            val `200`: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`700` else Colors.Greyscale.`200`
            val `100`: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`800` else Colors.Greyscale.`100`
            val `50`: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`900` else Colors.Greyscale.`50`
        }

        object AlertsAndStatus {
            val success: Color @Composable get() = Colors.AlertsStatus.Success
            val info: Color @Composable get() = Colors.AlertsStatus.Info
            val warning: Color @Composable get() = Colors.AlertsStatus.Warning
            val error: Color @Composable get() = Colors.AlertsStatus.Error
            val lightDisabled: Color @Composable get() = if (isSystemInDarkTheme()) Colors.AlertsStatus.DarkDisabled else Colors.AlertsStatus.LightDisabled
            val darkDisabled: Color @Composable get() = if (isSystemInDarkTheme()) Colors.AlertsStatus.LightDisabled else Colors.AlertsStatus.DarkDisabled
            val buttonDisabled: Color @Composable get() = Colors.AlertsStatus.ButtonDisabled
        }

        object Others {
            val red: Color @Composable get() = Colors.Others.Red
            val pink: Color @Composable get() = Colors.Others.Pink
            val purple: Color @Composable get() = Colors.Others.Purple
            val deepPurple: Color @Composable get() = Colors.Others.DeepPurple
            val indigo: Color @Composable get() = Colors.Others.Indigo
            val blue: Color @Composable get() = Colors.Others.Blue
            val lightBlue: Color @Composable get() = Colors.Others.LightBlue
            val cyan: Color @Composable get() = Colors.Others.Cyan
            val teal: Color @Composable get() = Colors.Others.Teal
            val green: Color @Composable get() = Colors.Others.Green
            val lightGreen: Color @Composable get() = Colors.Others.LightGreen
            val lime: Color @Composable get() = Colors.Others.Lime
            val yellow: Color @Composable get() = Colors.Others.Yellow
            val amber: Color @Composable get() = Colors.Others.Amber
            val orange: Color @Composable get() = Colors.Others.Orange
            val deepOrange: Color @Composable get() = Colors.Others.DeepOrange
            val brown: Color @Composable get() = Colors.Others.Brown
            val blueGrey: Color @Composable get() = Colors.Others.BlueGrey
        }

        object LightAndDark {
            val light1: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`1` else Colors.Others.White
            val light2: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`2` else Colors.Others.White
            val light3: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`3` else Colors.Others.White
            val light4: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`3` else Colors.Greyscale.`50`
            val light5: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`2` else Colors.Greyscale.`100`
            val light6: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`3` else Colors.Greyscale.`100`
            val light7: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`4` else Colors.Greyscale.`100`
            val light8: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`5` else Colors.Greyscale.`200`
            val light9: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`5` else Colors.Greyscale.`300`
            val lightBackground: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`1` else Colors.Greyscale.`100`
            val dark1: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Dark.`1`
            val dark2: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Dark.`2`
            val dark3: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Dark.`3`
            val dark4: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`50` else Colors.Dark.`3`
            val dark5: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`100` else Colors.Dark.`2`
            val dark6: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`100` else Colors.Dark.`3`
            val dark7: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`100` else Colors.Dark.`4`
            val dark8: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`200` else Colors.Dark.`5`
            val dark9: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`300` else Colors.Dark.`5`
            val darkBackground: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`100` else Colors.Dark.`1`
        }

        object Background {
            val backgroundOrange: Color @Composable get() = Colors.Background.Orange
            val backgroundBlue: Color @Composable get() = Colors.Background.Blue
            val backgroundGreen: Color @Composable get() = Colors.Background.Green
            val backgroundPurple: Color @Composable get() = Colors.Background.Purple
            val backgroundRed: Color @Composable get() = Colors.Background.Red
            val backgroundTeal: Color @Composable get() = Colors.Background.Teal
            val backgroundBrown: Color @Composable get() = Colors.Background.Brown
            val backgroundYellow: Color @Composable get() = Colors.Background.Yellow
            val backgroundGrey: Color @Composable get() = Colors.Background.Grey
        }

        object Transparent {
            val transparentOrange: Color @Composable get() = Colors.Transparent.Orange
            val transparentBlue: Color @Composable get() = Colors.Transparent.Blue
            val transparentGreen: Color @Composable get() = Colors.Transparent.Green
            val transparentPurple: Color @Composable get() = Colors.Transparent.Purple
            val transparentRed: Color @Composable get() = Colors.Transparent.Red
            val transparentTeal: Color @Composable get() = Colors.Transparent.Teal
            val transparentBrown: Color @Composable get() = Colors.Transparent.Brown
            val transparentYellow: Color @Composable get() = Colors.Transparent.Yellow
            val transparentGrey: Color @Composable get() = Colors.Transparent.Grey
        }

        object Components {
            val surfaceFilled: Color @Composable get() = Colors.Others.White
            val generalFrameLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`3` else Colors.Greyscale.`50`
            val generalFrameDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`50` else Colors.Dark.`3`
            val dropdownLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`4` else Colors.Others.White
            val dropdownDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Dark.`4`
            val dropdownIconLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`50` else Colors.Greyscale.`900`
            val dropdownIconDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`900` else Colors.Greyscale.`50`
            val modalLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`3` else Colors.Others.White
            val modalDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Dark.`3`
            val bottombarActionLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`1` else Colors.Others.White
            val bottombarActionDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Dark.`1`
            val searchSurfaceLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`600` else Colors.Greyscale.`400`
            val searchSurfaceDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`400` else Colors.Greyscale.`600`
            val categoryMenuLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`5` else Colors.Background.Orange
            val categoryMenuDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Background.Orange else Colors.Dark.`5`
            val menubarIcon500: Color @Composable get() = Colors.Greyscale.`500`
            val menubarSurfaceLight: Color @Composable get() = if (isSystemInDarkTheme()) Color(0x181A20D8) else Colors.Others.White
            val menubarSurfaceDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Color(0x181A20D8)
            val iconformDefault500: Color @Composable get() = Colors.Greyscale.`500`
            val iconformDisabled600: Color @Composable get() = Colors.Greyscale.`600`
            val mapRoadDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Dark.`5`
            object MapBackground {
                val light: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`3` else Colors.Primary.`50`
                val dark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Primary.`50` else Colors.Dark.`3`
            }
            val mapRoadLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`5` else Colors.Others.White
            object MenubarSelected {
                val light: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Primary.`900`
                val dark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Primary.`900` else Colors.Others.White
            }
        }

        object Buttons {
            val brand: Color @Composable get() = Colors.Primary.`900`
            val buttonLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`5` else Colors.Background.Orange
            val buttonDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Background.Orange else Colors.Dark.`5`
            val buttonDisabled: Color @Composable get() = Colors.AlertsStatus.ButtonDisabled
            object SocialMedia {
                val light: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`3` else Colors.Others.White
                val dark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Dark.`3`
            }
            val button50: Color @Composable get() = Colors.Greyscale.`50`
            val greyscaleIcon900: Color @Composable get() = Colors.Greyscale.`900`
            val whiteIcon: Color @Composable get() = Colors.Others.White
            val brandLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Primary.`900`
            val whiteDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Primary.`900` else Colors.Others.White
        }

        object InputForm2 {
            val defaultLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`800` else Colors.Greyscale.`500`
            val readOnlyLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`5` else Colors.Greyscale.`500`
            val defaultDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`500` else Colors.Greyscale.`800`
            val readOnlyDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`500` else Colors.Dark.`5`
            object ReadOnlyIcon {
                val light: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`500` else Colors.Greyscale.`700`
                val dark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`700` else Colors.Greyscale.`500`
            }
            object DisabledIcon {
                val light: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`700` else Colors.Greyscale.`500`
                val dark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`500` else Colors.Greyscale.`700`
            }
        }

        object Tag {
            val solidDefaultGrey600: Color @Composable get() = Colors.Greyscale.`600`
            object InvertedDefault {
                val light: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`5` else Colors.Background.Grey
                val dark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Background.Grey else Colors.Dark.`5`
            }
            object InvertedInfo {
                val light: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`5` else Colors.Background.Orange
                val dark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Background.Orange else Colors.Dark.`5`
            }
            object InvertedSuccess {
                val light: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`5` else Colors.Background.Green
                val dark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Background.Green else Colors.Dark.`5`
            }
            object InvertedWarning {
                val light: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`5` else Colors.Background.Yellow
                val dark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Background.Yellow else Colors.Dark.`5`
            }
            object InvertedError {
                val light: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`5` else Colors.Background.Red
                val dark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Background.Red else Colors.Dark.`5`
            }
        }

        object Additionals {
            object OvercolorFrame {
                val light: Color @Composable get() = Colors.Others.White
                val dark: Color @Composable get() = Colors.Greyscale.`900`
            }
            val AbsoluteBrand: Color @Composable get() = Colors.Primary.`900`
            val AbsoluteWhite: Color @Composable get() = Colors.Others.White
            val Absolute900: Color @Composable get() = Colors.Greyscale.`900`
            val lightBrand: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Primary.`900`
            val darkBrand: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Primary.`900` else Colors.Others.White
        }
    }

    object Stroke {
        object General {
            val brand: Color @Composable get() = Colors.Primary.`900`
            val white: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.Black else Colors.Others.White
            val black: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Others.Black
        }

        object Greyscale {
            val Greyscale900: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`50` else Colors.Greyscale.`900`
            val Greyscale800: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`100` else Colors.Greyscale.`800`
            val Greyscale700: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`200` else Colors.Greyscale.`700`
            val Greyscale600: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`300` else Colors.Greyscale.`600`
            val Greyscale500: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`400` else Colors.Greyscale.`500`
            val Greyscale400: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`500` else Colors.Greyscale.`400`
            val Greyscale300: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`600` else Colors.Greyscale.`300`
            val Greyscale200: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`700` else Colors.Greyscale.`200`
            val Greyscale100: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`800` else Colors.Greyscale.`100`
            val Greyscale50: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`900` else Colors.Greyscale.`50`
        }

        object AlertsAndStatus {
            val success: Color @Composable get() = Colors.AlertsStatus.Success
            val info: Color @Composable get() = Colors.AlertsStatus.Info
            val warning: Color @Composable get() = Colors.AlertsStatus.Warning
            val error: Color @Composable get() = Colors.AlertsStatus.Error
            val lightDisabled: Color @Composable get() = if (isSystemInDarkTheme()) Colors.AlertsStatus.DarkDisabled else Colors.AlertsStatus.LightDisabled
            val darkDisabled: Color @Composable get() = if (isSystemInDarkTheme()) Colors.AlertsStatus.LightDisabled else Colors.AlertsStatus.DarkDisabled
            val buttonDisabled: Color @Composable get() = Colors.AlertsStatus.ButtonDisabled
        }

        object Border {
            object FullStroke {
                val light: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`5` else Colors.Greyscale.`200`
                val dark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`200` else Colors.Dark.`5`
            }
            object SingleStrokeBorder {
                val light: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`5` else Colors.Greyscale.`200`
                val dark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`200` else Colors.Dark.`5`
            }
            object SingleStrokeDivider {
                val light: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`5` else Colors.Greyscale.`200`
                val dark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`200` else Colors.Dark.`5`
            }
        }

        object LightAndDark {
            val light0: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`1` else Colors.Others.White
            val light1: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`1` else Colors.Others.White
            val light2: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`2` else Colors.Others.White
            val light3: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`3` else Colors.Greyscale.`50`
            val light4: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`3` else Colors.Greyscale.`100`
            val light5: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`4` else Colors.Greyscale.`100`
            val light6: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`5` else Colors.Greyscale.`100`
            val light7: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`5` else Colors.Greyscale.`200`
            val light8: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`5` else Colors.Greyscale.`300`
            val dark0: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Dark.`1`
            val dark1: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Dark.`1`
            val dark2: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Dark.`2`
            val dark3: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`50` else Colors.Dark.`3`
            val dark4: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`100` else Colors.Dark.`3`
            val dark5: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`100` else Colors.Dark.`4`
            val dark6: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`100` else Colors.Dark.`5`
            val dark7: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`200` else Colors.Dark.`5`
            val dark8: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`300` else Colors.Dark.`5`
        }

        object InputForm {
            object DefaultAndFilled {
                val light: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`3` else Colors.Greyscale.`50`
                val dark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`50` else Colors.Dark.`3`
            }
            val readOnlyLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`2` else Colors.Greyscale.`100`
            val disabledLight: Color @Composable get() = if (isSystemInDarkTheme()) Colors.AlertsStatus.DarkDisabled else Colors.AlertsStatus.LightDisabled
            val readOnlyDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Greyscale.`100` else Colors.Dark.`2`
            val disabledDark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.AlertsStatus.LightDisabled else Colors.AlertsStatus.DarkDisabled
        }

        object Additionals {
            val toggle400: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Greyscale.`400`
            val tagOutlineDefault600: Color @Composable get() = Colors.Greyscale.`600`
            object SearchForm {
                val light: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Dark.`1` else Colors.Others.White
                val dark: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Dark.`1`
            }
            val absoluteBrand: Color @Composable get() = Colors.Primary.`900`
            val absoluteWhite: Color @Composable get() = Colors.Others.White
            val absolute900: Color @Composable get() = Colors.Greyscale.`900`
            val lightBrand: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Others.White else Colors.Primary.`900`
            val darkBrand: Color @Composable get() = if (isSystemInDarkTheme()) Colors.Primary.`900` else Colors.Others.White
        }
    }

    object GapAndPadding {
        object Positive {
            object GapPadding {
                val `0` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`0`
                val `2` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`2`
                val `4` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`4`
                val `6` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`6`
                val `8` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`8`
                val `10` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`10`
                val `12` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`12`
                val `14` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`14`
                val `16` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`16`
                val `18` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`18`
                val `20` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`20`
                val `22` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`22`
                val `24` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`24`
                val `28` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`28`
                val `32` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`32`
                val `36` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`36`
                val `40` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`40`
                val `44` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`44`
                val `48` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`48`
                val `56` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`56`
                val `64` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`64`
                val `72` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`72`
                val `80` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`80`
                val `88` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`88`
                val `96` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`96`
                val `104` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`104`
                val `112` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`112`
                val `120` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`120`
                val `128` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`128`
                val `136` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`136`
                val `144` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`144`
                val `152` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`152`
                val `160` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`160`
                val `180` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`180`
                val `200` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`200`
                val `220` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`220`
                val `240` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`240`
                val `260` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`260`
                val `280` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`280`
                val `300` = com.example.foc.ui.theme.GapAndPadding.Positive.GapPadding.`300`
            }
        }
        object Negative {
            object GapPadding {
                val `0` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`0`
                val `2` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`2`
                val `4` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`4`
                val `6` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`6`
                val `8` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`8`
                val `10` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`10`
                val `12` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`12`
                val `14` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`14`
                val `16` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`16`
                val `18` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`18`
                val `20` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`20`
                val `22` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`22`
                val `24` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`24`
                val `28` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`28`
                val `32` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`32`
                val `36` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`36`
                val `40` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`40`
                val `44` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`44`
                val `48` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`48`
                val `56` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`56`
                val `64` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`64`
                val `72` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`72`
                val `80` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`80`
                val `88` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`88`
                val `96` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`96`
                val `104` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`104`
                val `112` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`112`
                val `120` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`120`
                val `128` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`128`
                val `136` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`136`
                val `144` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`144`
                val `152` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`152`
                val `160` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`160`
                val `180` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`180`
                val `200` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`200`
                val `220` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`220`
                val `240` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`240`
                val `260` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`260`
                val `280` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`280`
                val `300` = com.example.foc.ui.theme.GapAndPadding.Negative.GapPadding.`300`
            }
        }
    }

    object CornerRadius {
        object Modern {
            object Radius {
                val `0` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`0`
                val `2` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`2`
                val `4` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`4`
                val `6` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`6`
                val `8` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`8`
                val `10` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`10`
                val `12` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`12`
                val `14` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`14`
                val `16` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`16`
                val `18` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`18`
                val `20` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`20`
                val `22` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`22`
                val `24` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`24`
                val `28` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`28`
                val `32` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`32`
                val `36` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`36`
                val `40` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`40`
                val `44` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`44`
                val `48` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`48`
                val `56` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`56`
                val `64` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`64`
                val `72` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`72`
                val `80` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`80`
                val `88` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`88`
                val `96` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`96`
                val `104` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`104`
                val `112` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`112`
                val `120` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`120`
                val `128` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`128`
                val `136` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`136`
                val `144` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`144`
                val `152` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`152`
                val `160` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`160`
                val `180` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`180`
                val `200` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`200`
                val `220` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`220`
                val `240` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`240`
                val `260` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`260`
                val `280` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`280`
                val `300` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`300`
                val `500` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`500`
                val `1000` = com.example.foc.ui.theme.CornerRadius.Modern.Radius.`1000`
                val round1000 = com.example.foc.ui.theme.CornerRadius.Modern.Radius.Round1000
                val button1000 = com.example.foc.ui.theme.CornerRadius.Modern.Radius.Round1000
                val button14 = com.example.foc.ui.theme.CornerRadius.Modern.Radius.Button14
                val button12 = com.example.foc.ui.theme.CornerRadius.Modern.Radius.Button12
                val button10 = com.example.foc.ui.theme.CornerRadius.Modern.Radius.Button10
                val button8 = com.example.foc.ui.theme.CornerRadius.Modern.Radius.Button8
                val line = com.example.foc.ui.theme.CornerRadius.Modern.Radius.Line
            }
        }
    }

    object WidthAndHeight {
        val fullWidth = "fullWidth"
        val contentWidth = "contentWidth"
        val twoCards = "twoCards"
        val threeCards = "threeCards"
        val fourCards = "fourCards"
    }
}

