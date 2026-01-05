package com.example.foc.ui.onboarding

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foc.R
import com.example.foc.ui.theme.CornerRadius
import com.example.foc.ui.theme.Greyscale200
import com.example.foc.ui.theme.Primary900
import com.example.foc.ui.theme.Spacing

@Composable
fun WelcomeScreen(
    onSignUp: () -> Unit,
    onLogin: () -> Unit,
    onGoogleContinue: () -> Unit,
    onFacebookContinue: () -> Unit,
    onTwitterContinue: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(Spacing.Space24),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier.size(120.dp)
        )

        Spacer(modifier = Modifier.height(Spacing.Space32))

        Text(
            text = "Let’s Get Started!",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )
        
        Text(
            text = "Let’s dive into your account",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
        )

        Spacer(modifier = Modifier.height(Spacing.Space48))

        // Social Buttons
        SocialLoginButton(
            iconRes = R.drawable.ic_logo, // Replace with Google icon
            text = "Continue with Google",
            onClick = onGoogleContinue
        )

        Spacer(modifier = Modifier.height(Spacing.Space16))

        SocialLoginButton(
            iconRes = R.drawable.ic_logo, // Replace with Facebook icon
            text = "Continue with Facebook",
            onClick = onFacebookContinue
        )

        Spacer(modifier = Modifier.height(Spacing.Space16))

        SocialLoginButton(
            iconRes = R.drawable.ic_logo, // Replace with Twitter icon
            text = "Continue with Twitter",
            onClick = onTwitterContinue
        )

        Spacer(modifier = Modifier.height(Spacing.Space32))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Don’t have an account?",
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
            )
            TextButton(onClick = onSignUp) {
                Text(text = "Sign up", color = Primary900, fontWeight = FontWeight.Bold)
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Already have an account?",
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
            )
            TextButton(onClick = onLogin) {
                Text(text = "Log in", color = Primary900, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Footer
        Text(
            text = "Privacy Policy · Terms of Service",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun SocialLoginButton(
    iconRes: Int,
    text: String,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(CornerRadius.Radius12),
        border = BorderStroke(1.dp, Greyscale200)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(Spacing.Space12))
            Text(
                text = text,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        }
    }
}
