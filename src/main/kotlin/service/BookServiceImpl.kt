package org.example.service

import org.example.Book
import org.example.factory.BookFactory
import java.time.LocalDate

class BookServiceImpl(private val bookFactory: BookFactory): BookService {

    override fun showBooks(books: List<Book>) {
        if (books.isEmpty()) {
            println("No books available.")
        } else {
            println("\nBooks:")
            books.forEach { book ->
                println("id ${book.id}: '${book.title}' by ${book.author} (Year: ${book.year})")
            }
        }
    }

    override fun sortBooksByTitle(books: List<Book>): List<Book> {
        return books.sortedBy { it.title }
    }

    override fun filterBooksByYear(books: List<Book>, year: Int): List<Book> {
        return books.filter { it.year > year }
    }

    override fun addBook(books: MutableList<Book>) {
        try {
            println("Enter book title:")
            val title = read()

            println("Enter the author of the book:")
            val author = read()

            println("Enter the year of publication:")
            val yearString = read()
            val year = yearString.toIntOrNull() ?: throw IllegalArgumentException("Year must be a number")

            if (title.isBlank() || author.isBlank() || year <= 0 || year > LocalDate.now().year) {
                throw IllegalArgumentException(" One or more fields are incorrect")
            } else {
                books.add(bookFactory.createBook(title, author, year))
                println("Book added.")
            }
        } catch (e: IllegalArgumentException) {
            println("Add book failed: ${e.message}")
        }
    }

    private fun read(): String {
        return readlnOrNull()?: throw IllegalArgumentException("Field should not be null!")
    }
}