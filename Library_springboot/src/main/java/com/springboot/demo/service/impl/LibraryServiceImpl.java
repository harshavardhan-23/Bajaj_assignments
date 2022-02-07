package com.springboot.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.demo.exception.ResourceNotFoundException;
import com.springboot.demo.model.Book;
import com.springboot.demo.repository.LibraryRepository;
import com.springboot.demo.service.LibraryService;
@Service
public class LibraryServiceImpl implements LibraryService {
	
	private LibraryRepository libraryrepository;
	
	

	public LibraryServiceImpl(LibraryRepository libraryrepository) {
		super();
		this.libraryrepository = libraryrepository;
	}



	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		return libraryrepository.save(book);
	}

	@Override
	public List<Book> saveBooks(List<Book> books) {
		// TODO Auto-generated method stub
		return libraryrepository.saveAll(books);
	}
	

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return libraryrepository.findAll();
	}



	@Override
	public Book getBookById(long bookid) {
		// TODO Auto-generated method stub
		Book book=libraryrepository.getById(bookid);
		if(book==null)
			throw new ResourceNotFoundException("Book","bookid", bookid);
		return libraryrepository.getById(bookid);
	}



	@Override
	public Book updateBook(Book book,long bookid) {
		// TODO Auto-generated method stub
		//book exist or not
		Book existingbook =libraryrepository.getById(bookid);
		if(existingbook ==null)
			throw new ResourceNotFoundException("Book","bookid", bookid);
		existingbook.setBookName(book.getBookName());
		existingbook.setAuthor(book.getAuthor());
		existingbook.setCost(book.getCost());
		existingbook.setPublisher(book.getPublisher());
		existingbook.setQuantity(book.getQuantity());
		//save existingbook obj
		libraryrepository.save(existingbook);
		
		return existingbook;
	}



	@Override
	public String deleteBook(long bookid) {
		// TODO Auto-generated method stub
		libraryrepository.deleteById(bookid);
		return "successfully deleted ";
	}




}
