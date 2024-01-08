package com.example.lastday.screens

//import androidx.compose.runtime.livedata.observeAsState

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lastday.R
import com.example.lastday.VeriTransferKatmanı.PostViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.lastday.retrofitMock.Post

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(postViewModel: PostViewModel) {
    val posts: List<Post> by postViewModel.posts.observeAsState(emptyList())

    LaunchedEffect(true) {
        postViewModel.fetchPosts() // Fetch posts when the screen launches
    }

    LazyColumn {
        items(posts) { post ->
            // Display post details using Text or other Composables
            Text(text = "Username: ${post.name}")
            Text(text = "Açıklama: ${post.description}")
        }
    }
}
    /*
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


*/