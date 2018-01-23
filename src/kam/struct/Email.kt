package kam.struct

import com.google.gson.GsonBuilder

class Email private constructor() {

    var email: String = ""
    var password: String = ""

    companion object {

        var instance = Email()

        private val gson = GsonBuilder().setPrettyPrinting().create()

        fun toJson(obj: Email) = gson.toJson(obj)
        fun fromJson(json: String) = gson.fromJson<Email>(json, Email::class.java)
    }
}