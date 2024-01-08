package com.example.lastday.retrofitMock

import java.util.Date

data class Post(
    val postid: Int,
    val userId: Int,
    val createdAt: Date,
    val name: String,
    val avatar: String, // link olacağı için string yaptım
    val like: Int,
    val kaydet: Int, // boolean yapamadığım için 0 ve 1 yapmayı deneyeceğim
    val description: String,
    val resim: String //link gelecek
)

data class User(
    val userId: Int,
    val createdAt: Date,
    val name: String,
    val avatar: String, // link olacağı için string yaptım
    //val posts: Post(postid),
    val password: String,
    val bio: String,
    //val counterPosts: Post(postid) //link gelecek

)
