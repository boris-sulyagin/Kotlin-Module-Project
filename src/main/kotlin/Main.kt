var listOfMenu: MutableList<Archive> = mutableListOf()

fun main() {
    archiveMenu()
}

fun archiveMenu() {
    MenuCreater.createMenu(
        MenuFilters.ARCHIVE,
        listOfMenu,
        create = { createArchive(listOfMenu) },
        complete = { println("Работа завершена") },
        selectItem = { archive -> noteMenu(archive as Archive) }
    )
}

fun noteMenu(archive: Archive) {
    MenuCreater.createMenu(
        MenuFilters.NOTE,
        archive.notes,
        create = { notesArcive -> createNote(notesArcive) },
        complete = { println("Переходим в меню архивов") },
        selectItem = { note -> (note as Note).readNote() }
    )
}

 