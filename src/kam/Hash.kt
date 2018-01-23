package kam

import java.security.MessageDigest



fun getHash(str: String, hash: String = "MD5"): String {
    val bytesOfMessage = str.toByteArray(Charsets.UTF_16)

    val md = MessageDigest.getInstance("MD5")
    val thedigest = md.digest(bytesOfMessage)

    val stringBuilder = StringBuilder()
    thedigest.forEach {
        stringBuilder.append(it)
    }
    return stringBuilder.toString()
}