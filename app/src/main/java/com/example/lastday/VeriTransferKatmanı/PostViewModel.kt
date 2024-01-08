package com.example.lastday.VeriTransferKatmanı

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lastday.retrofitMock.MockApiService
import com.example.lastday.retrofitMock.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

class PostViewModel: ViewModel() {

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://6599ea6e652b843dea53373b.mockapi.io/retrofitMock/:endpoint")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(MockApiService::class.java)
    // ??Define MockApiService interface and other necessary components

    suspend fun fetchPosts(){
        withContext(Dispatchers.IO) {
            //withContext(Dispatchers.IO) to perform the network operation on the background thread.
            try {
                val postsResponse = service.getPosts() // Fetch posts from API
                _posts.postValue(postsResponse) // Update LiveData with fetched posts
            } catch (e: Exception) {
                e.printStackTrace() // Print error for debugging
                _posts.postValue(emptyList()) // Update LiveData with an empty list in case of error
            }
        }
    }
}
