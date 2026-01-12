package com.example.foc.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foc.ui.theme.FocTheme
import com.example.foc.ui.theme.Variables

@Composable
fun ButtonShowcaseScreen() {
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Text(
                    text = "Button Showcase",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Preview all bottom bar button variants",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Variables.Greyscale.`500`
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            SectionTitle("Primary Button")
            PrimaryBottomBarButton(
                text = "Primary Button",
                onClick = { }
            )

            SectionTitle("Secondary Button")
            SecondaryBottomBarButton(
                text = "Secondary Button",
                onClick = { }
            )

            SectionTitle("Two Buttons")
            TwoButtonsBottomBar(
                primaryText = "Continue",
                secondaryText = "Back",
                onPrimaryClick = { },
                onSecondaryClick = { }
            )

            SectionTitle("Icon + Button")
            IconButtonBottomBar(
                icon = Icons.Default.Add,
                buttonText = "Add Task",
                onIconClick = { },
                onButtonClick = { }
            )

            SectionTitle("Onboarding")
            OnboardingBottomBar(
                pageCount = 3,
                currentPage = 1,
                onNextClick = { }
            )

            SectionTitle("Comments")
            CommentsBottomBar(
                onSendClick = { }
            )

            SectionTitle("Price + Button")
            PriceBottomBar(
                price = "$24.00",
                buttonText = "Checkout",
                onButtonClick = { }
            )
            
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title,
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
        style = MaterialTheme.typography.titleSmall,
        color = Variables.Greyscale.`500`,
        fontWeight = FontWeight.SemiBold
    )
}

@Preview(showBackground = true, name = "Light Theme")
@Composable
fun ButtonShowcaseScreenPreview() {
    FocTheme(darkTheme = false) {
        ButtonShowcaseScreen()
    }
}

@Preview(showBackground = true, name = "Dark Theme")
@Composable
fun ButtonShowcaseScreenDarkPreview() {
    FocTheme(darkTheme = true) {
        ButtonShowcaseScreen()
    }
}
