package com.example.crunchy_clone.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crunchy_clone.R
import com.example.crunchy_clone.ui.theme.Neutral100
import com.example.crunchy_clone.ui.theme.Neutral600
import com.example.crunchy_clone.ui.theme.Neutral850
import com.example.crunchy_clone.ui.theme.Orange400
import com.example.crunchy_clone.ui.theme.Typography


@Composable
fun Logo() {
    Row(Modifier.padding(top = 20.dp), verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier
                .height(36.dp)
                .width(36.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "image logo",
        )
        Text(
            text = stringResource(id = R.string.app_name_commercial),
            color = Orange400,
            style = Typography.titleLarge,
            fontWeight = FontWeight(900)
        )
    }
}

@Composable
fun CrunchyButton(
    enabled: Boolean = true,
    modifier: Modifier,
    text: String,
    textColor: Color,
    color: Color,
    onClick: () -> Unit
) {
    val finalColor = if(enabled) color else Color.Transparent
    val finalBorder = if(enabled) null else BorderStroke(2.dp,Neutral600)
    val finalTextColor = if(enabled) textColor else Neutral600

    TextButton(
        onClick = { onClick() },
        modifier = modifier.fillMaxWidth().heightIn(40.dp).padding(0.dp),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        shape = RoundedCornerShape(0),
        contentPadding = PaddingValues(),
        border = finalBorder
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().height(40.dp).background(color = finalColor),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = finalTextColor,
                style = Typography.labelMedium,
                fontWeight = FontWeight(800)
            )
        }
    }
}

@Composable
fun CrunchyOutlineButton(
    modifier: Modifier,
    text: String,
    textColor: Color,
    borderColor: Color,
    shape: Shape,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = { onClick() },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(40.dp),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        contentPadding = PaddingValues(),
        shape = shape,
        border = BorderStroke(2.dp, borderColor),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = textColor,
                style = Typography.labelMedium,
                fontWeight = FontWeight(800)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CrunchyInput(label: String) {
    val textValue = remember {
        mutableStateOf("")
    }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        label = { Text(text = label) },
        value = textValue.value,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Neutral100,
            containerColor = Neutral850,
            unfocusedLabelColor = Neutral600,
            focusedLabelColor = Orange400,
            focusedIndicatorColor = Orange400
        ),
        textStyle = TextStyle.Default.copy(fontSize = 16.sp),
        singleLine = true,
        shape = RoundedCornerShape(0),
        keyboardOptions = KeyboardOptions.Default,
        onValueChange = {
            textValue.value = it
        },
    )
}
