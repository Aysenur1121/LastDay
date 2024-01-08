package com.example.lastday.retrofitMock

//import com.example.lastday.Post
import retrofit2.http.GET

interface MockApiService {
    @GET("/post") // Endpoint to fetch posts(posts resource'u)
    suspend fun getPosts(): List<com.example.lastday.retrofitMock.Post>

    @GET("/users") // Endpoint to fetch posts(posts resource'u)
    suspend fun getUsers(): List<com.example.lastday.retrofitMock.User>
// Define the model structure for Post
// (suspend indicates that it's a coroutine-based function,
// List<Post> represents the expected response data type (a list of Post/User objects))
}
