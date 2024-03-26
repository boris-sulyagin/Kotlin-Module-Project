object MenuCreater {

    fun<T : Menu> createMenu(
        menuFilter: MenuFilters,
        listOfMenu: MutableList<T>,
        create: (MutableList<T>) -> Unit,
        complete: () -> Unit,
        selectItem: (Menu) -> Unit
    ) {

        fun <T : Menu> printArchiveMenu(menu: MutableList<T>) {
            println("0. Создать архив")
            menu.forEachIndexed { index, element -> println("${index + 1}. ${element.name}") }
            println("${menu.size + 1}. Выход")
        }

        fun <T : Menu> printNoteMenu(menu: MutableList<T>) {
            println("0. Создать заметку")
            menu.forEachIndexed { index, element -> println("${index + 1}. ${element.name}") }
            println("${menu.size + 1}. Вернуться")
        }

        while (true) {

            when(menuFilter) {
                MenuFilters.ARCHIVE -> printArchiveMenu(listOfMenu)
                MenuFilters.NOTE -> printNoteMenu(listOfMenu)
            }

            when(val input = checkNumber(listOfMenu.size)) {
                0 -> create(listOfMenu)
                listOfMenu.size + 1 -> {
                    complete()
                    break
                }
                else -> selectItem(listOfMenu[input - 1])
            }
        }

    }
}