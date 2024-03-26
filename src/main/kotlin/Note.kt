class Note(override val name: String, val text: String) : Menu() {
    fun readNote() {
        println("Текст блокнота $name")
        println("$text")
    }
}