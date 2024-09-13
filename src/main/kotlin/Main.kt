package org.example

import org.example.factory.BookFactory
import org.example.factory.BookFactoryImpl
import org.example.service.BookService
import org.example.service.BookServiceImpl

fun main() {
    val bookFactory:BookFactory = BookFactoryImpl()
    val books = bookFactory.createBookList()
    val bookService: BookService = BookServiceImpl(bookFactory)
    var choice: Int
    do {
        println("\nMenu:")
        println("1. Add book")
        println("2. Show all books")
        println("3. Filter books by year")
        println("4. Sort books by title")
        println("0. Exit")
        print("Enter your choice: ")
        choice = readlnOrNull()?.toIntOrNull() ?: -1

        when (choice) {
            1 -> bookService.addBook(books)
            2 -> bookService.showBooks(books)
            3 -> {
                print("Enter the year: ")
                val year = readlnOrNull()?.toIntOrNull() ?: 0
                val filteredBooks = bookService.filterBooksByYear(books, year)
                bookService.showBooks(filteredBooks)
            }

            4 -> {
                val sortedBooks = bookService.sortBooksByTitle(books)
                bookService.showBooks(sortedBooks)
            }

            0 -> println("Exiting...")
            else -> println("Invalid choice, please try again.")
        }
    } while (choice != 0)
}