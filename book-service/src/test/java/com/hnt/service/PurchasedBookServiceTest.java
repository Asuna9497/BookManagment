package com.hnt.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hnt.BookRepository;
import com.hnt.PurchasedBookRepository;
import com.hnt.entity.Book;
import com.hnt.entity.Category;
import com.hnt.entity.ERole;
import com.hnt.entity.PurchasedBook;
import com.hnt.entity.Role;
import com.hnt.entity.User;

@ExtendWith(MockitoExtension.class)
class PurchasedBookServiceTest {
	@InjectMocks
	PurchasedBookService purchasedBookService;
	
	@Mock
	PurchasedBookRepository purchasedBookRepository;
	
	@Mock
	BookRepository bookRepository;
	
	@Test
	void testSavePurchasedBook() {
		PurchasedBook purchasedBook = new PurchasedBook();
		purchasedBook.setBookId(1);
		purchasedBook.setId(1);
		User reader = new User();
		reader.setId(1l);
		reader.setUsername("Ram");
		reader.setEmail("vaibhav.v@v.com");
		purchasedBook.setReader(reader);
		when(purchasedBookRepository.save(purchasedBook)).thenReturn(purchasedBook);
		assertEquals(1, purchasedBookService.savePurchasedBook(purchasedBook).getId());
	
	}
	@Test
	void testGetPurchasedBook() {
		LocalDateTime localDateTime = LocalDateTime.now();
		List<PurchasedBook> purchasedBookList = new ArrayList<>();
		PurchasedBook purchasedBook = new PurchasedBook();
		purchasedBook.setBookId(1);
		purchasedBook.setId(1);
		User reader = new User();
		reader.setId(1l);
		reader.setUsername("Ram");
		reader.setEmail("vaibhav.v@v.com");
		purchasedBook.setReader(reader);
		purchasedBookList.add(purchasedBook);
		when(purchasedBookRepository.findAll()).thenReturn(purchasedBookList);
		User author = new User();
		author.setId(1l);
		author.setUsername("Ram");
		author.setEmail("k.k@k.com");
		author.setPassword("abc");
		Role r = new Role();
		r.setName(ERole.ROLE_READER);
		Set<Role> role = new LinkedHashSet<Role>();
		role.add(r);
		author.setRoles(role);

		Book book = new Book();
		book.setId(1);
		book.setCategory(Category.Biography);
		book.setContent("This is novel");
		book.setLogo("novel.img");
		book.setPrice(200);
		book.setPublishedDate(localDateTime.toLocalDate());
		book.setPublisher("manga");
		book.setTitle("Kirito");
		book.setActive(true);
		book.setAuthor(author);
		Optional<Book> books = Optional.of(book);
		List<Book> bList= new ArrayList<>();
		bList.add(book);
		when(bookRepository.findById(1)).thenReturn(books);
		assertEquals(bList, purchasedBookService.getPurchasedBook("vaibhav.v@v.com"));
		
	}

}
