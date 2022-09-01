package com.hnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnt.PurchasedBooksRepository;
import com.hnt.entity.PurchasedBooks;

@Service
public class PurchasedBooksService {
	
	@Autowired
	PurchasedBooksRepository repo;
	
	public Iterable<PurchasedBooks>getPurchasedBooks(){
		return repo.findAll();
	}
	
	public PurchasedBooks buyBook(PurchasedBooks pBooks) {
		return repo.save(pBooks);
	}

}
