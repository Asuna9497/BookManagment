package com.hnt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnt.BookRepository;
import com.hnt.entity.Book;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
//	public List<Book> getBooks(String category, String author, int price, String publisher){
//		 return bookRepository.searchBook(category, author, price, publisher);
//	}
	
	public Iterable<Book> getBooks(){
		return bookRepository.findAll();
	}
	
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	
	
}
