package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                BusinessCard(modifier = Modifier.fillMaxSize().background(color = Color(0XffEAE3F2)))
            }
        }
    }
}

@Composable
fun CardHeader(text: Int, modifier: Modifier = Modifier, image: Painter){
  Box(modifier.fillMaxWidth().padding(16.dp), contentAlignment = Alignment.Center) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = image, 
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
        Text(text = stringResource(text), modifier = Modifier.padding(top = 8.dp), fontSize = 40.sp, fontWeight = FontWeight.Bold)
    }
  }
}

@Composable
fun CardInfoContainer(modifier: Modifier = Modifier) {
        Box(
            modifier
                .fillMaxHeight()
                .padding(16.dp), contentAlignment = Alignment.BottomEnd) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0XffCFBAE1), shape = RoundedCornerShape(8.dp))
                .padding(16.dp),
                verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                CardElementRow(Icons.Outlined.Email, R.string.email, modifier)
                CardElementRow(Icons.Outlined.Face, R.string.card_position, modifier)
                CardElementRow(
                    Icons.Outlined.ThumbUp,
                    R.string.social_media,
                    modifier
                )
            }
        }
}

@Composable
fun CardElementRow(icon: ImageVector, text: Int, modifier: Modifier = Modifier) {
    Row(modifier = Modifier
        .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        ) {
        Icon(icon, contentDescription = "Email icon")
        Text(text = stringResource(text), modifier = modifier.padding(start = 8.dp, end = 8.dp))
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        CardHeader(R.string.card_name, Modifier.weight(2f), painterResource(R.drawable.pfp))
        CardInfoContainer(Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard(modifier = Modifier.fillMaxSize().background(color = Color(0XffEAE3F2)))
    }
}