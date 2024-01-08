package com.example.lastday

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.lastday.VeriTransferKatmanı.PostViewModel
import com.example.lastday.navigation.AppNavigation
//import com.example.lastday.navigation.SayfaGecisleri
import com.example.lastday.navigation.navControllerAmbient


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityContent()
        }
    }
}
@SuppressLint("RememberReturnType")
@Composable
fun MainActivityContent() {
    val navController = rememberNavController()
    val postViewModel = remember { PostViewModel() } // Initialize PostViewModel


    CompositionLocalProvider(navControllerAmbient provides navController) {
        AppNavigation(navController = navController, postViewModel = postViewModel)
    }
}

/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LastDayTheme {
        SayfaGecisleri()
    }
}
*/
/* // bundan sonrası deneme partı, kullanılmıyor
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
*/







