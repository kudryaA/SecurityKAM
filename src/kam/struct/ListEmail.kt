package kam.struct

class ListEmail private constructor(): ArrayList<String>() {
    companion object {
        val instance = ListEmail()
    }
}