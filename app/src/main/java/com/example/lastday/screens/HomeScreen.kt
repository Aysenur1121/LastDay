package com.example.lastday.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lastday.PostSamples
import com.example.lastday.R

@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(
            text = "Home Screen",
            fontFamily = FontFamily.Serif,
            fontSize = 22.sp
        )

    }

    Row(modifier = Modifier.padding(11.dp)){//add padding around our message
        Image(
            painter = painterResource(R.drawable.profil),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp) //Set image size 40 dp
                .clip(CircleShape) //Clip image to be shaped as a circle
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)  //resmin etrafındaki renkli çerçeve
        )
        Spacer(modifier = Modifier.width(8.dp)) // add a horizontal space between the image and the column

        Column{

            Text(
                text = "Nur",
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp)) //Add a vertical space between the author abd message texts
            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp){ //shadowElevation yazıyı çerçeveşeyen çerçevenin görünürlüğünü/kontrastını belirliyor
                Text(
                    text = "Şikayet ediyorum",
                    modifier = Modifier.padding(all = 4.dp), //yazının olduğu çerçevenin yazıdan uzaklığı
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(4.dp)) // fotoğraf ve yazı arasında dikey boşluk bırakıyorum


            Image(
                painter = painterResource(R.drawable.foto),
                contentDescription = "Şikayet edilen resim",
                modifier = Modifier
                    .size(240.dp) //Set image size 40 dp
                    .clip(RectangleShape) //Clip image to be shaped as a circle
                    //.border(1.5.dp, MaterialTheme.colorScheme.primary, RectangleShape)  //resmin etrafındaki renkli çerçeve (boyut değişikliğinden dolayı sildim)
            )
        }


    }
}

