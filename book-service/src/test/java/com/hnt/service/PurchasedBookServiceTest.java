package com.hnt.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hnt.PurchasedBookRepository;
import com.hnt.entity.PurchasedBook;
import com.hnt.entity.Reader;

@ExtendWith(MockitoExtension.class)
class PurchasedBookServiceTest {
	@InjectMocks
	PurchasedBookService purchasedBookService;
	
	@Mock
	PurchasedBookRepository purchasedBookRepository;
	
	@Test
	void testSavePurchasedBook() {
		PurchasedBook purchasedBook = new PurchasedBook();
		purchasedBook.setBookId(1);
		purchasedBook.setId(1);
		Reader reader = new Reader();
		reader.setId(1);
		reader.setName("Vaibhav");
		reader.setEmail("vaibhav.v@v.com");
		purchasedBook.setReader(reader);
		when(purchasedBookRepository.save(purchasedBook)).thenReturn(purchasedBook);
		assertEquals(1, purchasedBookService.savePurchasedBook(purchasedBook).getId());
	
	}
	@Test
	void testGetPurchasedBook() {
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
		when(purchasedBookRepository.findAll()).thenReturn(purchasedBookList);
		assertEquals(purchasedBookList, purchasedBookService.getPurchasedBook("vaibhav.v@v.com"));
		
	}

}
