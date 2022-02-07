package com.springboot.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.model.Book;

import com.springboot.demo.service.LibraryService;

@RestController
@RequestMapping("/api/library")
public class LibraryController {
	private LibraryService libraryservice;

	public LibraryController(LibraryService libraryservice) {
		super();
		this.libraryservice = libraryservice;
	}
	
	//build add book rest api
	@PostMapping
	public Book saveBook(@RequestBody Book book) {
		return libraryservice.saveBook(book);
	}
	//build add list of books rest api
	@PostMapping("/addbooks")
	public List<Book> saveBooks(@RequestBody List<Book> books){
		return libraryservice.saveBooks(books);
	}
	//build get all books rest api
	@GetMapping
	public List<Book> getAllBooks(){
		return libraryservice.getAllBooks();
	}
	//build get book by id
	@GetMapping("{bookid}")
	public Book getBookById(@PathVariable("bookid")  long bookid){
		return libraryservice.getBookById(bookid);
	}
	//build update book rest api
	@PutMapping("{bookid}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bookid") long bookid) {
		return libraryservice.updateBook(book, bookid);
	}
	//build delete book rest api
	@DeleteMapping("{bookid}")
	public void deleteBook(@PathVariable("bookid") long bookid) {
		libraryservice.deleteBook(bookid);
		ResponseEntity<Book> responseentity=new ResponseEntity("deleted sucessfully",HttpStatus.OK);
	}
	
}
