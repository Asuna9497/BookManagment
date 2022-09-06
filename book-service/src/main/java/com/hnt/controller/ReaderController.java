package com.hnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hnt.entity.PurchasedBook;
import com.hnt.service.PurchasedBookService;

@RestController
@RequestMapping("/api/v1/digitalbooks/Readers")
public class ReaderController extends BaseController {

	@Autowired
	PurchasedBookService purchasedBookService;

	/**
	 * This method will fetch the purchased book according to the email passed
	 * 
	 * @param email
	 * @return list of purchased book
	 */
	@GetMapping("/{emailId}/books")
	public List<PurchasedBook> getAllPurchasedBooks(@PathVariable("emailId") String email) {
		return purchasedBookService.getPurchasedBook(email);

	}

}
