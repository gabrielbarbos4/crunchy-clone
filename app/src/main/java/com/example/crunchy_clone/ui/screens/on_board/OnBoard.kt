package com.example.crunchy_clone.ui.screens.on_board

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.crunchy_clone.R
import com.example.crunchy_clone.ui.shared.components.CrunchyButton
import com.example.crunchy_clone.ui.shared.components.CrunchyOutlineButton
import com.example.crunchy_clone.ui.shared.components.Logo
import com.example.crunchy_clone.ui.theme.Neutral400
import com.example.crunchy_clone.ui.theme.Neutral900
import com.example.crunchy_clone.ui.theme.Orange400
import com.example.crunchy_clone.ui.theme.Typography


@Composable
fun OnBoard(
    onRegisterButtonClick: () -> Unit,
    onLoginButtonClick: () -> Unit
) {
    Surface(
        Modifier
            .background(color = Neutral900)
            .fillMaxSize()
    ) {
        Column(
            Modifier
                .background(color = Neutral900)
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Logo()
            OnBoardImage()
            Footer(onRegisterButtonClick, onLoginButtonClick)
        }
    }
}

@Preview
@Composable
fun OnBoardPreview() {
    OnBoard(onLoginButtonClick = {}, onRegisterButtonClick = {})
}

@Composable
fun OnBoardImage() {
    Image(
        painter = painterResource(id = R.drawable.on_board),
        contentDescription = "imagem onBoard",
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7F)
            .padding(top = 96.dp, bottom = 16.dp)
    )
}

@Composable
fun Footer(onRegisterButtonClick: () -> Unit, onLoginButtonClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom
    ) {
        CrunchyButton(
            color = Orange400,
            text = stringResource(id = R.string.create_account).uppercase(),
            textColor = Neutral900
        ) { onRegisterButtonClick() }
        CrunchyOutlineButton(
            text = stringResource(id = R.string.login).uppercase(),
            textColor = Orange400,
            borderColor = Orange400,
            shape = RoundedCornerShape(0),
        ) { onLoginButtonClick() }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.browse).uppercase(),
            color = Orange400,
            style = Typography.labelMedium,
            fontWeight = FontWeight(800)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Terms()
    }
}

@Composable
fun Terms() {
    Text(
        buildAnnotatedString {
            append("By using Crunchyroll you are agreeign to our ")
            withStyle(style = SpanStyle(color = Orange400)) {
                append("Terms")
            }
            append(" & ")
            withStyle(style = SpanStyle(color = Orange400)) {
                append("Privacy Policy")
            }
            append(", and you confirm that you are at least 16 years of age")
        },
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = Neutral400,
        style = Typography.labelSmall,
        fontWeight = FontWeight(800)
    )
}
