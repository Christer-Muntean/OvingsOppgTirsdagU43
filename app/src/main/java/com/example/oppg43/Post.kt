package com.example.oppg43

class Post(
    private val id: String = java.util.UUID.randomUUID().toString(),
    var description: String,
    var likes: Int
) {

    init {
        likes = (1..1000).random()

        removeCurseWords()
    }

    fun removeCurseWords() {
        description = description.replace("faen", "***")
    }

    companion object {

        fun getPostsWith500AndMoreLikes(listOfPosts : MutableList<Post>) : MutableList<Post> {
            val listOfPostsWith500AndMoreLikes = mutableListOf<Post>()

            for (post in listOfPosts) {
                if(post.likes >= 500){
                    listOfPostsWith500AndMoreLikes.add(post)
                }
            }
            return  listOfPostsWith500AndMoreLikes
        }
    }
}