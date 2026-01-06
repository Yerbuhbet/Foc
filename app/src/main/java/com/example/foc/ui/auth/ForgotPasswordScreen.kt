package com.example.foc.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foc.R
import com.example.foc.ui.theme.CornerRadius
import com.example.foc.ui.theme.Primary900
import com.example.foc.ui.theme.Spacing
import com.example.foc.ui.theme.Greyscale200
import com.example.foc.ui.theme.Greyscale500
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordFlow(
    onBackToLogin: () -> Unit,
    onResetSuccess: () -> Unit
) {
    var currentStep by remember { mutableIntStateOf(1) }
    var email by remember { mutableStateOf("") }
    
    Scaffold(
        topBar = {
            if (currentStep < 4) {
                TopAppBar(
                    title = { },
                    navigationIcon = {
                        IconButton(onClick = {
                            if (currentStep > 1) currentStep-- else onBackToLogin()
                        }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = stringResource(R.string.back)
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background
                    )
                )
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            when (currentStep) {
                1 -> EmailInputScreen(
                    email = email,
                    onEmailChange = { email = it },
                    onContinue = { currentStep = 2 }
                )
                2 -> EnterOTPScreen(
                    onVerify = { currentStep = 3 }
                )
                3 -> CreateNewPasswordScreen(
                    onSave = { currentStep = 4 }
                )
                4 -> ResetSuccessScreen(
                    onGoToHome = onResetSuccess
                )
            }
        }
    }
}

@Composable
fun EmailInputScreen(
    email: String,
    onEmailChange: (String) -> Unit,
    onContinue: () -> Unit
) {
    val isEmailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Spacing.Space24)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(Spacing.Space24))
        
        Text(
            text = stringResource(R.string.forgot_password_title),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(Spacing.Space12))
        
        Text(
            text = stringResource(R.string.forgot_password_desc),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(Spacing.Space32))
        
        OutlinedTextField(
            value = email,
            onValueChange = onEmailChange,
            label = { Text(stringResource(R.string.registered_email)) },
            placeholder = { Text(stringResource(R.string.email)) },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
            shape = RoundedCornerShape(CornerRadius.Radius12),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Primary900,
                unfocusedBorderColor = Greyscale200
            )
        )
        
        Spacer(modifier = Modifier.height(Spacing.Space48))
        
        Button(
            onClick = onContinue,
            enabled = isEmailValid,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(CornerRadius.RadiusRound),
            colors = ButtonDefaults.buttonColors(
                containerColor = Primary900,
                disabledContainerColor = Primary900.copy(alpha = 0.5f)
            )
        ) {
            Text(
                text = stringResource(R.string.send_otp),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun EnterOTPScreen(
    onVerify: () -> Unit
) {
    var otp by remember { mutableStateOf("") }
    var timer by remember { mutableIntStateOf(56) }
    
    LaunchedEffect(key1 = timer) {
        if (timer > 0) {
            delay(1000)
            timer--
        }
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Spacing.Space24)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(Spacing.Space24))
        
        Text(
            text = stringResource(R.string.enter_otp_title),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(Spacing.Space12))
        
        Text(
            text = stringResource(R.string.enter_otp_desc),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(Spacing.Space48))
        
        // Simplified OTP input for simulation
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            repeat(4) { index ->
                val char = otp.getOrNull(index)?.toString() ?: ""
                Surface(
                    modifier = Modifier.size(70.dp),
                    shape = RoundedCornerShape(CornerRadius.Radius12),
                    border = androidx.compose.foundation.BorderStroke(1.dp, if (char.isNotEmpty()) Primary900 else Greyscale200),
                    color = if (char.isNotEmpty()) Primary900.copy(alpha = 0.05f) else MaterialTheme.colorScheme.surface
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = char,
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
        
        // This hidden text field would capture input in a real app
        // For simulation, we'll just use a normal TextField below it or similar
        Spacer(modifier = Modifier.height(Spacing.Space32))
        
        OutlinedTextField(
            value = otp,
            onValueChange = { if (it.length <= 4) otp = it },
            modifier = Modifier.width(0.dp).height(0.dp), // Hidden capturing field
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        
        // Since I can't easily show the keyboard/capture focus here, let's add a visible input for demo
        OutlinedTextField(
            value = otp,
            onValueChange = { 
                if (it.length <= 4) {
                    otp = it
                    if (it.length == 4) onVerify()
                }
            },
            label = { Text("Enter 4-digit code") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            shape = RoundedCornerShape(CornerRadius.Radius12)
        )
        
        Spacer(modifier = Modifier.height(Spacing.Space48))
        
        Text(
            text = stringResource(R.string.resend_code_in, timer),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
        
        TextButton(
            onClick = { timer = 60 },
            enabled = timer == 0
        ) {
            Text(
                text = stringResource(R.string.resend_code),
                color = if (timer == 0) Primary900 else Greyscale500,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun CreateNewPasswordScreen(
    onSave: () -> Unit
) {
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    
    val isFormValid = password.isNotEmpty() && password == confirmPassword && password.length >= 8
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Spacing.Space24)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(Spacing.Space24))
        
        Text(
            text = stringResource(R.string.secure_account_title),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(Spacing.Space12))
        
        Text(
            text = stringResource(R.string.secure_account_desc),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(Spacing.Space32))
        
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(stringResource(R.string.new_password)) },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_logo), // Placeholder
                        contentDescription = null
                    )
                }
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            shape = RoundedCornerShape(CornerRadius.Radius12),
            colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Primary900)
        )
        
        Spacer(modifier = Modifier.height(Spacing.Space20))
        
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text(stringResource(R.string.confirm_new_password)) },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
            trailingIcon = {
                IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_logo), // Placeholder
                        contentDescription = null
                    )
                }
            },
            visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            shape = RoundedCornerShape(CornerRadius.Radius12),
            colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Primary900)
        )
        
        Spacer(modifier = Modifier.height(Spacing.Space48))
        
        Button(
            onClick = onSave,
            enabled = isFormValid,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(CornerRadius.RadiusRound),
            colors = ButtonDefaults.buttonColors(
                containerColor = Primary900,
                disabledContainerColor = Primary900.copy(alpha = 0.5f)
            )
        ) {
            Text(
                text = stringResource(R.string.save_new_password),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun ResetSuccessScreen(
    onGoToHome: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Spacing.Space24),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo), // Success illustration placeholder
            contentDescription = null,
            modifier = Modifier.size(180.dp)
        )
        
        Spacer(modifier = Modifier.height(Spacing.Space40))
        
        Text(
            text = stringResource(R.string.all_set_title),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(Spacing.Space16))
        
        Text(
            text = stringResource(R.string.all_set_desc),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(Spacing.Space48))
        
        Button(
            onClick = onGoToHome,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(CornerRadius.RadiusRound),
            colors = ButtonDefaults.buttonColors(containerColor = Primary900)
        ) {
            Text(
                text = stringResource(R.string.go_to_homepage),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}
