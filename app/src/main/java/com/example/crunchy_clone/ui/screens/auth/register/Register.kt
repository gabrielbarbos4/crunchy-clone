package com.example.crunchy_clone.ui.screens.auth.register

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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumTouchTargetEnforcement
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
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
import com.example.crunchy_clone.ui.theme.Neutral850
import com.example.crunchy_clone.ui.theme.Neutral900
import com.example.crunchy_clone.ui.theme.Orange400
import com.example.crunchy_clone.ui.theme.Typography

@Preview(showBackground = true)
@Composable
fun Register() {
    Surface(Modifier.background(color = Neutral900).fillMaxSize()) {
        Column(
            Modifier
                .background(color = Neutral900)
                .padding(16.dp)
                .fillMaxSize(),
        ) {
            RegisterScreenTitle()
            RegisterScreenContent()
        }
    }
}

@Composable
fun RegisterScreenTitle() {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(id = R.string.capital_create_account),
        textAlign = TextAlign.Center,
        color = Neutral100,
        fontSize = Typography.bodyLarge.fontSize,
        fontWeight = FontWeight(600)
    )
}

@Composable
fun RegisterScreenContent() {
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ConstraintLayout {
                val (logo, inputContainer, subscriptionInfo, terms, button, haveAccount) = createRefs()

                LogoConstraintWrapper(modifier = Modifier
                    .constrainAs(logo) { }
                )
                InputConstraintWrapper(
                    modifier = Modifier.constrainAs(inputContainer) {
                        top.linkTo(logo.bottom, margin = 24.dp)
                    }
                )
                SubscriptionConstraintWrapper(
                    Modifier.constrainAs(subscriptionInfo) {
                        top.linkTo(inputContainer.bottom, margin = 16.dp)
                    },
                )
                TermsConstraintWrapper(Modifier.constrainAs(terms) {
                        top.linkTo(subscriptionInfo.bottom, margin = 20.dp)
                    }
                )
                CreateAccountButtonConstraintWrapper(Modifier.constrainAs(button) {
                        top.linkTo(terms.bottom, margin = 20.dp)
                    }
                )
                HaveAccountConstraintWrapper(Modifier.constrainAs(haveAccount) {
                        top.linkTo(button.bottom, margin = 42.dp)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubscriptionConstraintWrapper(modifier: Modifier) {
    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        var myState by remember { mutableStateOf(false) }

        CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
            Checkbox(
                checked = myState,
                onCheckedChange = { myState = it },
                colors = CheckboxDefaults.colors(
                    checkmarkColor = Neutral850,
                    uncheckedColor = Neutral100,
                    checkedColor = Orange400
                ),
                modifier = Modifier.padding(0.dp),
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = stringResource(id = R.string.subscription_info),
            color = Neutral100,
            style = Typography.labelSmall,
        )
    }
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
            append("By creating your account with us, you are agreeign to our ")
            withStyle(style = SpanStyle(color = Orange400)) {
                append("Terms")
            }
            append(" & ")
            withStyle(style = SpanStyle(color = Orange400)) {
                append("Privacy Policy")
            }
            append(", and you confirm that you are at least 16 years of age")
        },
        modifier = modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = Neutral400,
        style = Typography.labelSmall,
        fontWeight = FontWeight(800)
    )
}

@Composable
fun CreateAccountButtonConstraintWrapper(modifier: Modifier) {
    var a by remember {
        mutableStateOf(false)
    }

    CrunchyButton(
        enabled = a,
        modifier = modifier,
        color = Orange400,
        textColor = Neutral100,
        text = stringResource(id = R.string.create_account).uppercase(),
        onClick = { a = !a }
    )
}

@Composable
fun HaveAccountConstraintWrapper(modifier: Modifier) {
    Text(
        buildAnnotatedString {
            append("Already have an account? ")
            withStyle(style = SpanStyle(color = Orange400)) {
                append("Login")
            }
        },
        modifier = modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = Neutral100,
        style = Typography.bodySmall,
        fontWeight = FontWeight(500)
    )
}
