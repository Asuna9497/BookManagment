package com.hnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnt.BookRepository;
import com.hnt.entity.Book;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	public Iterable<Book> getBooks(){
		 return bookRepository.findAll();
	}
	
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

}
