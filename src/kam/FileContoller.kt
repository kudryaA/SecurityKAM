package kam

import java.io.FileReader
import java.io.FileWriter

fun write(path: String, text: String) {
    val writer = FileWriter(path)
    writer.write(text)
    writer.close()
}

fun read(path: String): String {
    val reader = FileReader(path)
    val res = reader.readText()
    reader.close()
    return res
}