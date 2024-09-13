package org.example.factory

import org.example.Book

interface BookFactory {

    fun createBookList(): MutableList<Book>

    fun createBook(title: String, author: String, year: Int): Book
}