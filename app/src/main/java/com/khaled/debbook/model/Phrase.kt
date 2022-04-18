package com.khaled.debbook.model

class Phrase(
    val english: String,
    val hungarian: String,
    val audio : String
) {
    val getAudio: String
        get() = "raw/$audio"

}