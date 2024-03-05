package com.example.crunchy_clone.ui.screens.on_board

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.crunchy_clone.R
import com.example.crunchy_clone.ui.theme.Neutral900
import com.example.crunchy_clone.ui.theme.Orange400
import com.example.crunchy_clone.ui.theme.Typography
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import com.example.crunchy_clone.ui.theme.Neutral400

@Preview(showBackground = true)
@Composable
fun OnBoard() {
    Column(
        Modifier
            .background(color = Neutral900)
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Logo()
        OnBoardImage()
        Footer()
    }
}

@Composable
fun Logo() {
    Row(
        Modifier.padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .height(36.dp)
                .width(36.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "image logo",
        )
        Text(
            text = "crunchyroll",
            color = Orange400,
            style = Typography.titleLarge,
            fontWeight = FontWeight(900)
        )
    }
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
fun Footer() {
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom
    ) {
        TextButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Orange400)
                .height(40.dp)
        ) {
            Text(
                text = "CREATE ACCOUNT",
                color = Neutral900,
                style = Typography.labelMedium,
                fontWeight = FontWeight(800)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            border = BorderStroke(2.dp, Orange400),
            shape = RoundedCornerShape(0)
        ) {
            Text(
                text = "LOG IN",
                color = Orange400,
                style = Typography.labelMedium,
                fontWeight = FontWeight(800)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "BROWSE CRUNCHYROLL",
            color = Orange400,
            style = Typography.labelMedium,
            fontWeight = FontWeight(800)
        )
        Spacer(modifier = Modifier.height(20.dp))
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
}
