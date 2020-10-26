package com.example.oppg43

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val listOfPosts = mutableListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPostsFromServer()

        post_button.setOnClickListener {
            val post = Post(
                description = description_editText.text.toString(),
                likes = 0)

            listOfPosts.add(post)

            generateUi()
        }
    }

    fun getPostsFromServer() {

        val postOne = Post( description = "Ut på tur!", likes = 0)
        val postTwo = Post( description = "Jeg liker å se på tv", likes = 0)
        val postThree = Post( description = "ÅÅÅå så søøt for faen <3", likes = 0)

        listOfPosts.add(postOne)
        listOfPosts.add(postTwo)
        listOfPosts.add(postThree)

        generateUi()
    }

    fun generateUi() {

        //val listWith500AndMoreLikes = Post.getPostsWith500AndMoreLikes(listOfPosts)

        postList_layout.removeAllViews()
        for (post in listOfPosts) {
            postList_layout.addView(createTextView(post))
        }
    }

    fun createTextView(post: Post) : TextView {
        val textView = TextView(this)
        textView.text = "${post.description}\nLikes: ${post.likes}\n\n"

        textView.setOnClickListener{
            post.likes++
            generateUi()
        }

        return textView
    }

}