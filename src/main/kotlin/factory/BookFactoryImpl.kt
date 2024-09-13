package org.example.factory

import org.example.Book

class BookFactoryImpl: BookFactory {
    private var id: Int = 1
    override fun createBookList(): MutableList<Book> {
        return mutableListOf(
            createBook("The Last Wish", "Andrzej Sapkowski", 1993),
            createBook("Sword of Destiny", "Andrzej Sapkowski", 1992),
            createBook("Blood of Elves", "Andrzej Sapkowski", 1994),
            createBook("Time of Contempt ", "Andrzej Sapkowski", 1995),
            createBook("Baptism of Fire", "Andrzej Sapkowski", 1996),
            createBook("The Tower of the Swallow", "Andrzej Sapkowski", 1997),
            createBook("The Lady of the Lake ", "Andrzej Sapkowski", 1999),
            createBook("Season of Storms", "Andrzej Sapkowski", 2013)
        )
    }

    override fun createBook(title: String, author: String, year: Int): Book = Book(id++, title, author, year)
}