fun checkNumber(sizeOfMenu: Int) : Int {
    while (true) {
        var input = readln().toIntOrNull()
        if (input == null) {
            println("Необходимо ввести число")
        } else if ((input < 0) || (input > sizeOfMenu + 1)) {
            println("Нет такого пункта")
        } else return input
    }
}

fun checkInput() : String {
    while (true) {
        var input = readln()
        if (input.isBlank()) println("Элемент не может быть пустым, повторите ввод") else return input
    }
}

fun createArchive(archiveList: MutableList<Archive>) {
    println("Введите название архива")
    var input = checkInput()
    var notesList: MutableList<Note> = mutableListOf()
    archiveList.add(Archive(input, notesList))
}

fun createNote(notesList: MutableList<Note>) {
    println("Введите название заметки")
    var input = checkInput()
    println("Введите текст заметки")
    var textInput = checkInput()
    var newNote = Note(input, textInput)
    notesList.add(newNote)
}