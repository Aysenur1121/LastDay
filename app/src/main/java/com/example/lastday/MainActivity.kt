package com.example.lastday

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lastday.ui.theme.LastDayTheme
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.core.content.contentValuesOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.lastday.navigation.AppNavigation


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val controller= rememberNavController()
            LastDayTheme{
                AppNavigation(navController = controller as NavHostController
                )
                /*Surface(modifier = Modifier.fillMaxSize()){
                    PostCard(Post("Android", "Jetpack Compose"))
                } */
            }
        }
    }
}




data class Post(val author: String, val body: String)

@Composable
fun TopBar(
    name: String,
    modifier: Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ){
        Icon(imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}

@Composable
fun Reportes (post: List<Post>){
    LazyColumn{
        items(post) { post ->
            PostCard(post)
        }
    }
}
@Composable
fun PostCard(pst: Post){
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
                text = pst.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp)) //Add a vertical space between the author abd message texts
            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp){ //shadowElevation yazıyı çerçeveşeyen çerçevenin görünürlüğünü/kontrastını belirliyor
                Text(
                    text = pst.body,
                    modifier = Modifier.padding(all = 4.dp), //yazının olduğu çerçevenin yazıdan uzaklığı
                    style = MaterialTheme.typography.bodyMedium
                )


            }

        }
    }


}
//OldEnd

@Preview
@Composable
fun PreviewReportes(){
    LastDayTheme {
        Reportes(PostSamples.HomeSample)
    }
}


//OldStart
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewPostCard(){
    LastDayTheme{  // Theme adını UI ın altındaki theme dosyasından bulabilirsin,dosyanınadına göre değişiyor
        Surface{
            PostCard(
                pst = Post("Ayşenur", "Şikayet ediyorum.")
            )

        }
    }

}
//OldEnd



