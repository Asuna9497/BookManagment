package com.hnt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnt.BookRepository;
import com.hnt.PurchasedBookRepository;
import com.hnt.entity.Book;
import com.hnt.entity.PurchasedBook;

/**
 * This service class for purchased book this class have method to save the
 * purchased book
 * 
 * @author priyanka
 *
 */
@Service
public class PurchasedBookService {
	@Autowired
	PurchasedBookRepository purchasedBookRepository;
	
	@Autowired
	BookRepository bookRepository;

	/**
	 * This method will save PurchasedBook in database
	 * 
	 * @param purchasedBook
	 * @return PurchasedBook
	 */
	public PurchasedBook savePurchasedBook(PurchasedBook purchasedBook) {
		return purchasedBookRepository.save(purchasedBook);
	}

	/**
	 * This method will fetch all purchased books then filter it on the basis of
	 * email passed
	 * 
	 * @param email
	 * @return sorted list of purchased books
	 */
	public List<Book> getPurchasedBook(String email) {
		List<Book> sortedList = new ArrayList<>();
		List<PurchasedBook> booklist = purchasedBookRepository.findAll();
		for (PurchasedBook purchasedBook : booklist) {
			if (purchasedBook.getReader().getEmail().equals(email)) {
				Optional<Book> books = bookRepository.findById(purchasedBook.getBookId());
				Book book = books.get();
				sortedList.add(book);
			}
		}
		return sortedList;

	}
}
