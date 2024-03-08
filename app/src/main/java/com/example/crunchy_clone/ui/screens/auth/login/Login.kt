package com.example.crunchy_clone.ui.screens.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.crunchy_clone.R
import com.example.crunchy_clone.ui.components.CrunchyButton
import com.example.crunchy_clone.ui.components.CrunchyInput
import com.example.crunchy_clone.ui.components.Logo
import com.example.crunchy_clone.ui.theme.Neutral100
import com.example.crunchy_clone.ui.theme.Neutral400
import com.example.crunchy_clone.ui.theme.Neutral900
import com.example.crunchy_clone.ui.theme.Orange400
import com.example.crunchy_clone.ui.theme.Typography

@Composable
fun Login(onLoginButtonClick: () -> Unit) {
    Surface(
        Modifier
            .background(color = Neutral900)
            .fillMaxSize()
    ) {
        Column(
            Modifier
                .background(color = Neutral900)
                .padding(16.dp)
                .fillMaxSize(),
        ) {
            LoginScreenTitle()
            LoginScreenContent(onLoginButtonClick)
        }
    }
}

@Composable
fun LoginScreenTitle() {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(id = R.string.login_button).capitalize(),
        textAlign = TextAlign.Center,
        color = Neutral100,
        fontSize = Typography.bodyLarge.fontSize,
        fontWeight = FontWeight(600)
    )
}

@Composable
fun LoginScreenContent(onLoginButtonClick: () -> Unit) {
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ConstraintLayout {
                val (logo, inputContainer, welcome, terms, button, forgotPassword) = createRefs()

                LogoConstraintWrapper(modifier = Modifier.constrainAs(logo) {})
                WelcomeConstraintWrapper(modifier = Modifier.constrainAs(welcome) {
                        top.linkTo(logo.bottom, margin = 20.dp)
                    }
                )
                InputConstraintWrapper(
                    modifier = Modifier.constrainAs(inputContainer) {
                        top.linkTo(welcome.bottom, margin = 20.dp)
                    }
                )
                TermsConstraintWrapper(Modifier.constrainAs(terms) {
                        top.linkTo(inputContainer.bottom, margin = 20.dp)
                    }
                )
                LoginButtonConstraintWrapper(
                    onLoginButtonClick,
                    Modifier.constrainAs(button) {
                        top.linkTo(terms.bottom, margin = 20.dp)
                    }
                )
                ForgotPasswordOrCreateAccountConstraintWrapper(Modifier.constrainAs(forgotPassword) {
                        top.linkTo(button.bottom, margin = 20.dp)
                    }
                )
            }
        }
    }
}

@Composable
fun ForgotPasswordOrCreateAccountConstraintWrapper(modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = modifier,
            color = Orange400,
            text = "Forgot password?  ",
            textAlign = TextAlign.Center,
            style = Typography.bodySmall,
            fontWeight = FontWeight(800)
        )
        Text(
            modifier = modifier.height(20.dp),
            color = Neutral100,
            text = "| ",
            style = Typography.bodyMedium,
            fontWeight = FontWeight(800)
        )
        Text(
            modifier = modifier,
            color = Orange400,
            text = " Create Account",
            textAlign = TextAlign.Center,
            style = Typography.bodySmall,
            fontWeight = FontWeight(800)
        )
    }
}

@Composable
fun WelcomeConstraintWrapper(modifier: Modifier) {
    Text(
        modifier = modifier,
        color = Neutral100,
        text = stringResource(id = R.string.login_welcome),
        textAlign = TextAlign.Center,
        style = Typography.bodySmall
    )
}

@Composable
fun LogoConstraintWrapper(modifier: Modifier) {
    Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Logo()
    }
}

@Composable
fun InputConstraintWrapper(modifier: Modifier) {
    Column(modifier = modifier) {
        CrunchyInput(label = stringResource(id = R.string.email))
        Spacer(modifier = Modifier.height(8.dp))
        CrunchyInput(label = stringResource(id = R.string.password))
    }
}

@Composable
fun TermsConstraintWrapper(modifier: Modifier) {
    Text(
        buildAnnotatedString {
            append("By login with your account, you are agreeign to our")
            withStyle(style = SpanStyle(color = Orange400)) {
                append("Terms")
            }
            append(" & ")
            withStyle(style = SpanStyle(color = Orange400)) {
                append("Privacy Policy ")
            }
            append("and you confirm that you are at least 16 years of age")
        },
        modifier = modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = Neutral400,
        style = Typography.labelSmall,
        fontWeight = FontWeight(800)
    )
}

@Composable
fun LoginButtonConstraintWrapper(
    onLoginButtonClick: () -> Unit,
    modifier: Modifier
) {
    var a by remember {
        mutableStateOf(false)
    }

    CrunchyButton(
        enabled = a,
        modifier = modifier,
        color = Orange400,
        textColor = Neutral100,
        text = stringResource(id = R.string.login_button).uppercase(),
        onClick = { onLoginButtonClick() }
    )
}