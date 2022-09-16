package com.hnt.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hnt.entity.PurchasedBook;
import com.hnt.entity.Reader;
import com.hnt.service.PurchasedBookService;

@ExtendWith(MockitoExtension.class)
class ReaderControllerTest {
	@Mock
	PurchasedBookService purchasedBookService;
	@InjectMocks
	ReaderController readerController;

	@Test
	void testGetAllPurchasedBooks() {
		List<PurchasedBook> purchasedBookList = new ArrayList<>();
		PurchasedBook purchasedBook = new PurchasedBook();
		purchasedBook.setBookId(1);
		purchasedBook.setId(1);
		Reader reader = new Reader();
		reader.setId(1);
		reader.setName("Vaibhav");
		reader.setEmail("vaibhav.v@v.com");
		purchasedBook.setReader(reader);
		purchasedBookList.add(purchasedBook);
		when(purchasedBookService.getPurchasedBook("vaibhav.v@v.com")).thenReturn(purchasedBookList);
		assertEquals(purchasedBookList, readerController.getAllPurchasedBooks("vaibhav.v@v.com"));
	}

}
