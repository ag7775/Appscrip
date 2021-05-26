package com.shivam.kotlin.appscriptask.util

import com.shivam.kotlin.appscriptask.modal.Question

class Constants{
    companion object{
        val questionList = arrayListOf<Question>(
            Question(
                question = "Who is the best cricketer in the world?",
                option1 = "Sachin Tendulkar",
                option2 = "Virat Kohli",
                option3 = "Adam Gilchrist",
                option4 = "Jacques Kallis",
            ),
            Question(
                question = "What are the colors in the Indian national flag? Select all:",
                option1 = "White",
                option2 = "Yellow",
                option3 = "Orange",
                option4 = "Green",
            )
        )

    }
}