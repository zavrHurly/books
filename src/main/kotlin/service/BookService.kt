package org.example.service

import org.example.Book

interface BookService {

    fun showBooks(books: List<Book>)

    fun sortBooksByTitle(books: List<Book>): List<Book>

    fun filterBooksByYear(books: List<Book>, year: Int): List<Book>

    fun addBook(books: MutableList<Book>)
}