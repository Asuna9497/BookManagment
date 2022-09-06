package com.hnt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnt.PurchasedBookRepository;
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
	public List<PurchasedBook> getPurchasedBook(String email) {
		List<PurchasedBook> sortedList = new ArrayList<>();
		Iterable<PurchasedBook> booklist = purchasedBookRepository.findAll();
		for (PurchasedBook book : booklist) {
			if (book.getReader().getEmail().equals(email)) {
				sortedList.add(book);
			}
		}

		return sortedList;

	}
}