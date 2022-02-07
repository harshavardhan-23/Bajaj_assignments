package com.springboot.demo.service;

import java.util.List;

import com.springboot.demo.model.Book;

public interface LibraryService {
	Book saveBook(Book  book);
	List<Book> saveBooks(List<Book> books);
	List<Book> getAllBooks();
	Book getBookById(long bookid);
	Book updateBook(Book book,long bookid);
	String deleteBook(long bookid);
}
