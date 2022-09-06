package com.hnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnt.BookRepository;
import com.hnt.entity.Book;

/**
 * This is BookService class which have methods to fetch books and save book
 * 
 * @author priyanka
 *
 */
@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	/**
	 * This method will fetch the all books
	 * 
	 * @return list of books
	 */
	public Iterable<Book> getBooks() {
		Iterable<Book> books = bookRepository.findAll();
		if (null != books) {
			return books;

		} else {
			throw new IllegalArgumentException("No book found!");
		}
	}

	/**
	 * This method will save the Book in DB
	 * 
	 * @param book
	 * @return saved Book object
	 */
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

}
