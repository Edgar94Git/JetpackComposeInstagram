package com.ereyes.jetpackcomposeinstagram

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/****
 * Project: JetpackComposeInstagram
 * From: com.ereyes.jetpackcomposeinstagram
 * Created by Edgar Reyes Gonzalez on 11/4/2023 at 6:54 PM
 * All rights reserved 2023.
 ****/

@Composable
fun TwitterCard() {
    var chat: Boolean by remember { mutableStateOf(false) }
    var rt: Boolean by remember { mutableStateOf(false) }
    var like: Boolean by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF161D26))
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_01),
            contentDescription = "",
            modifier = Modifier
                .clip(CircleShape)
                .size(55.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
            ) {
                TextTitle("Edgar Gonzalez", Modifier.padding(end = 8.dp))
                DefaultText("@Ereyes94", Modifier.padding(end = 8.dp))
                DefaultText("7h", Modifier.padding(end = 8.dp))
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.ic_dots),
                    contentDescription = "",
                    tint = Color.White
                )
            }
            TextBody(
                "Mensaje digital que se envía a través de la red social Twitter® y que no puede rebasar un número limitado de caracteres.",
                Modifier.padding(bottom = 16.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.profile_01),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(10)),
                contentScale = ContentScale.Crop
            )
            Row(modifier = Modifier.padding(top = 16.dp)) {
                SocialIcon(
                    modifier = Modifier.weight(1f),
                    onSelectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_chat),
                            contentDescription = "",
                            tint = Color(0xFF8E8B98)
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_chat_filled),
                            contentDescription = "",
                            tint = Color(0xFF8E8B98)
                        )
                    },
                    isSelected = chat
                ) {
                    chat = !chat
                }
                SocialIcon(
                    modifier = Modifier.weight(1f),
                    onSelectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_rt),
                            contentDescription = "",
                            tint = Color(0xFF8E8B98)
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_rt),
                            contentDescription = "",
                            tint = Color(0xFF00FF27)
                        )
                    },
                    isSelected = rt
                ) {
                    rt = !rt
                }
                SocialIcon(
                    modifier = Modifier.weight(1f),
                    onSelectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_like),
                            contentDescription = "",
                            tint = Color(0xFF8E8B98)
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_like_filled),
                            contentDescription = "",
                            tint = Color(0xFFFF0000)
                        )
                    },
                    isSelected = like
                ) {
                    like = !like
                }
            }
        }
    }
}

@Composable
fun SocialIcon(
    modifier: Modifier,
    onSelectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    isSelected: Boolean,
    onItemSelected: () -> Unit
) {
    val defaultValue = 1

    Row(
        modifier = modifier.clickable { onItemSelected() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isSelected)
            selectedIcon()
        else
            onSelectedIcon()
        Text(
            text = if (isSelected) (defaultValue + 1).toString() else defaultValue.toString(),
            color = Color(0xFF8E8B98),
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 4.dp)
        )
    }

}

@Composable
fun TextBody(text: String, modifier: Modifier = Modifier) {
    Text(text = text, modifier = modifier, Color.White)
}

@Composable
fun TextTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        color = Color.White,
        modifier = modifier,
        fontWeight = FontWeight.ExtraBold
    )
}

@Composable
fun DefaultText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        color = Color.Gray,
        modifier = modifier
    )
}

@Composable
fun TuitDivider() {
    Divider(
        modifier = Modifier
            .padding(top = 4.dp)
            .height(0.7.dp)
            .fillMaxWidth(),
        color = Color(0xFF8E8B98)
    )
}