package com.example.foc.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foc.ui.theme.FocTheme
import com.example.foc.ui.theme.Variables

@Composable
fun BottomBarActionContainer(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    val isDark = isSystemInDarkTheme()
    val backgroundColor = if (isDark) Variables.Dark.`1` else Variables.Others.White
    val borderColor = if (isDark) Variables.Dark.`5` else Variables.Greyscale.`100`

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp))
            .padding(horizontal = 24.dp)
            .padding(top = 24.dp, bottom = 36.dp),
        content = content
    )
}

@Composable
fun FocButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = Variables.Primary.`900`,
    contentColor: Color = Variables.Others.White,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = Variables.AlertsStatus.ButtonDisabled,
            disabledContentColor = Variables.Others.White
        ),
        enabled = enabled,
        shape = RoundedCornerShape(1000.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.2.sp,
                lineHeight = 16.sp * 1.6f
            ),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun PrimaryBottomBarButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    BottomBarActionContainer(modifier = modifier) {
        FocButton(
            text = text,
            onClick = onClick,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun SecondaryBottomBarButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isDark = isSystemInDarkTheme()
    val containerColor = if (isDark) Variables.Dark.`5` else Variables.Primary.`50`
    val contentColor = if (isDark) Variables.Others.White else Variables.Primary.`900`

    BottomBarActionContainer(modifier = modifier) {
        FocButton(
            text = text,
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(),
            containerColor = containerColor,
            contentColor = contentColor
        )
    }
}

@Composable
fun TwoButtonsBottomBar(
    primaryText: String,
    secondaryText: String,
    onPrimaryClick: () -> Unit,
    onSecondaryClick: () -> Unit,
    modifier: Modifier = Modifier,
    isPrimaryEnabled: Boolean = true
) {
    val isDark = isSystemInDarkTheme()
    val secondaryContainerColor = if (isDark) Variables.Dark.`5` else Variables.Primary.`50`
    val secondaryContentColor = if (isDark) Variables.Others.White else Variables.Primary.`900`

    BottomBarActionContainer(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FocButton(
                text = secondaryText,
                onClick = onSecondaryClick,
                modifier = Modifier.weight(1f),
                containerColor = secondaryContainerColor,
                contentColor = secondaryContentColor
            )
            FocButton(
                text = primaryText,
                onClick = onPrimaryClick,
                modifier = Modifier.weight(1f),
                enabled = isPrimaryEnabled
            )
        }
    }
}

@Composable
fun IconButtonBottomBar(
    icon: ImageVector,
    buttonText: String,
    onIconClick: () -> Unit,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isDark = isSystemInDarkTheme()
    val iconContainerColor = if (isDark) Variables.Dark.`5` else Variables.Primary.`50`
    val iconContentColor = if (isDark) Variables.Others.White else Variables.Primary.`900`

    BottomBarActionContainer(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onIconClick,
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(1000.dp))
                    .background(iconContainerColor)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = iconContentColor,
                    modifier = Modifier.size(33.dp)
                )
            }
            FocButton(
                text = buttonText,
                onClick = onButtonClick,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun OnboardingBottomBar(
    pageCount: Int,
    currentPage: Int,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    BottomBarActionContainer(
        modifier = modifier
            .padding(bottom = 28.dp) // Specific padding for onboarding as per Figma
    ) {
        // Redefining padding for onboarding specifically
        // Figma has pt-20, pb-28
        // Our container has pt-24, pb-36. I'll just use the container but adjust if needed.
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(pageCount) { index ->
                    val isSelected = index == currentPage
                    Box(
                        modifier = Modifier
                            .height(8.dp)
                            .width(if (isSelected) 32.dp else 8.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(if (isSelected) Variables.Primary.`900` else if (isSystemInDarkTheme()) Variables.Dark.`5` else Variables.Greyscale.`300`)
                    )
                }
            }

            IconButton(
                onClick = onNextClick,
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(1000.dp))
                    .background(Variables.Primary.`900`)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null,
                    tint = Variables.Others.White,
                    modifier = Modifier.size(33.dp)
                )
            }
        }
    }
}

@Composable
fun CommentsBottomBar(
    onSendClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var commentText by remember { mutableStateOf("") }
    val isDark = isSystemInDarkTheme()
    val inputBackgroundColor = if (isDark) Variables.Dark.`3` else Variables.Greyscale.`50`
    val inputBorderColor = if (isDark) Variables.Dark.`3` else Variables.Greyscale.`50`

    BottomBarActionContainer(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = commentText,
                onValueChange = { commentText = it },
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                placeholder = {
                    Text(
                        "Add a comment ...",
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = Variables.Greyscale.`500`,
                            letterSpacing = 0.2.sp
                        )
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = inputBackgroundColor,
                    unfocusedContainerColor = inputBackgroundColor,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    cursorColor = Variables.Primary.`900`
                ),
                shape = RoundedCornerShape(10.dp),
                singleLine = true
            )

            IconButton(
                onClick = {
                    if (commentText.isNotBlank()) {
                        onSendClick(commentText)
                        commentText = ""
                    }
                },
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(1000.dp))
                    .background(Variables.Primary.`900`)
            ) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = null,
                    tint = Variables.Others.White,
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    }
}

@Composable
fun PriceBottomBar(
    price: String,
    buttonText: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isDark = isSystemInDarkTheme()
    val labelColor = if (isDark) Variables.Greyscale.`200` else Variables.Greyscale.`700`
    val priceColor = if (isDark) Variables.Others.White else Variables.Greyscale.`900`

    BottomBarActionContainer(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.wrapContentWidth()
            ) {
                Text(
                    text = "Total price",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = labelColor,
                        letterSpacing = 0.2.sp,
                        lineHeight = 12.sp * 1.6f
                    )
                )
                Text(
                    text = price,
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = priceColor,
                        lineHeight = 24.sp * 1.6f
                    )
                )
            }
            FocButton(
                text = buttonText,
                onClick = onButtonClick,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true, name = "Light Theme")
@Composable
fun BottomBarButtonsPreview() {
    FocTheme(darkTheme = false) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Variables.Others.White)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                "Primary Button",
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Bold,
                color = Variables.Greyscale.`900`
            )
            PrimaryBottomBarButton(text = "Primary Button", onClick = {})

            Text(
                "Secondary Button",
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Bold,
                color = Variables.Greyscale.`900`
            )
            SecondaryBottomBarButton(text = "Secondary Button", onClick = {})

            Text(
                "Two Buttons",
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Bold,
                color = Variables.Greyscale.`900`
            )
            TwoButtonsBottomBar(
                primaryText = "Primary",
                secondaryText = "Secondary",
                onPrimaryClick = {},
                onSecondaryClick = {}
            )

            Text(
                "Icon Button Bottom Bar",
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Bold,
                color = Variables.Greyscale.`900`
            )
            IconButtonBottomBar(
                icon = Icons.Default.Add,
                buttonText = "Add Task",
                onIconClick = {},
                onButtonClick = {}
            )

            Text(
                "Onboarding Bottom Bar",
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Bold,
                color = Variables.Greyscale.`900`
            )
            OnboardingBottomBar(
                pageCount = 3,
                currentPage = 0,
                onNextClick = {}
            )

            Text(
                "Comments Bottom Bar",
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Bold,
                color = Variables.Greyscale.`900`
            )
            CommentsBottomBar(onSendClick = {})

            Text(
                "Price Bottom Bar",
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Bold,
                color = Variables.Greyscale.`900`
            )
            PriceBottomBar(
                price = "$24.00",
                buttonText = "Checkout",
                onButtonClick = {}
            )
        }
    }
}

@Preview(showBackground = true, name = "Dark Theme")
@Composable
fun BottomBarButtonsDarkPreview() {
    FocTheme(darkTheme = true) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Variables.Dark.`1`)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                "Primary Button",
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Bold,
                color = Variables.Others.White
            )
            PrimaryBottomBarButton(text = "Primary Button", onClick = {})

            Text(
                "Secondary Button",
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Bold,
                color = Variables.Others.White
            )
            SecondaryBottomBarButton(text = "Secondary Button", onClick = {})

            Text(
                "Two Buttons",
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Bold,
                color = Variables.Others.White
            )
            TwoButtonsBottomBar(
                primaryText = "Primary",
                secondaryText = "Secondary",
                onPrimaryClick = {},
                onSecondaryClick = {}
            )

            Text(
                "Icon Button Bottom Bar",
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Bold,
                color = Variables.Others.White
            )
            IconButtonBottomBar(
                icon = Icons.Default.Add,
                buttonText = "Add Task",
                onIconClick = {},
                onButtonClick = {}
            )

            Text(
                "Onboarding Bottom Bar",
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Bold,
                color = Variables.Others.White
            )
            OnboardingBottomBar(
                pageCount = 3,
                currentPage = 1,
                onNextClick = {}
            )

            Text(
                "Comments Bottom Bar",
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Bold,
                color = Variables.Others.White
            )
            CommentsBottomBar(onSendClick = {})

            Text(
                "Price Bottom Bar",
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Bold,
                color = Variables.Others.White
            )
            PriceBottomBar(
                price = "$24.00",
                buttonText = "Checkout",
                onButtonClick = {}
            )
        }
    }
}
