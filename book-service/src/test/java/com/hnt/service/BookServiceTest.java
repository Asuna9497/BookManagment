package com.hnt.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hnt.BookRepository;
import com.hnt.entity.Book;
import com.hnt.entity.Category;
import com.hnt.entity.User;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

	@InjectMocks
	BookService bookService;

	@Mock
	BookRepository bookRepository;

	@Test
	void testSaveBook() {
		LocalDateTime localDateTime = LocalDateTime.now();
		User author = new User();
		author.setId(1l);
		author.setUsername("Ram");

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
		when(bookRepository.save(book)).thenReturn(book);
		bookService.saveBook(book);
		assertEquals(1, book.getId());
	}

	@Test
	void testGetBooks() {
		List<Book> bookList = new ArrayList<>();
		LocalDateTime localDateTime = LocalDateTime.now();
		User author = new User();
		author.setId(1l);
		author.setUsername("Ram");

		Book book1 = new Book();
		book1.setId(1);
		book1.setCategory(Category.Biography);
		book1.setContent("This is novel");
		book1.setLogo("novel.img");
		book1.setPrice(200);
		book1.setPublishedDate(localDateTime.toLocalDate());
		book1.setPublisher("manga");
		book1.setTitle("Kirito");
		book1.setActive(true);
		book1.setAuthor(author);

		Book book2 = new Book();
		book2.setId(2);
		book2.setCategory(Category.Detective);
		book2.setContent("This is short story");
		book2.setLogo("shortstory.img");
		book2.setPrice(500);
		book2.setPublishedDate(localDateTime.toLocalDate());
		book2.setPublisher("norton");
		book2.setTitle("Asuna");
		book2.setActive(true);
		book2.setAuthor(author);

		bookList.add(book1);
		bookList.add(book2);

		when(bookRepository.findAll()).thenReturn(bookList);
		Iterable<Book> actualList = bookService.getBooks();
		assertEquals(bookList, actualList);

	}

	@Test
	void testGetBooksForException() {
		assertThrows(IllegalArgumentException.class, () -> {
			java.util.List<Book> bookList = null;
			when(bookRepository.findAll()).thenReturn(bookList);
			bookService.getBooks();
		});
	}

}
