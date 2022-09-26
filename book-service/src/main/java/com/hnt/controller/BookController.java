package com.hnt.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.hnt.entity.Book;
import com.hnt.entity.PurchasedBook;
import com.hnt.entity.User;
import com.hnt.service.BookService;
import com.hnt.service.PurchasedBookService;
import com.hnt.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * This is controller class for book
 * 
 * @author priyanka
 *
 */
@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/api/v1/digitalbooks")
public class BookController extends BaseController {

	@Autowired
	BookService bookService;

	@Autowired
	UserService userService;

	@Autowired
	PurchasedBookService purchasedBookService;

	/**
	 * This method will first fetch the all the books from database then will sort
	 * list according to search parameters
	 * 
	 * @param category
	 * @param authorName
	 * @param price
	 * @param publisher
	 * @return sortedList
	 *
	 */
	@GetMapping("/books/search")
	List<Book> getBooks(@RequestParam(value = "category", required = false) String category,
			@RequestParam(value = "author", required = false) String authorName,
			@RequestParam(value = "price", required = false) Float price,
			@RequestParam(value = "publisher", required = false) String publisher) {
		log.debug("inside getBooks");
		List<Book> bookList = Streamable.of(bookService.getBooks()).toList();
		List<Book> sortedList = null;
		if (null != bookList) {
			sortedList = bookList.stream()
					.filter(b -> b.getCategory().toString().equalsIgnoreCase(category)
							|| (null != authorName && null != b.getAuthor()
									&& b.getAuthor().getUsername().equalsIgnoreCase(authorName))
							|| (null != price && b.getPrice() == price) || b.getPublisher().equalsIgnoreCase(publisher))
					.collect(Collectors.toList());
		}

		return sortedList;
	}

	/**
	 * This method will - 1.find author by id 2.set this author in book object
	 * 3.save book object in database
	 * 
	 * @param book
	 * @param authorId
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/author/{authorId}/books")
	Integer saveBook(@Valid @RequestBody Book book, @PathVariable("authorId") int authorId) throws Exception {
		User user = userService.getUserById(authorId);
		if (null != user) {
			book.setAuthor(user);
			bookService.saveBook(book);
			return book.getId();
		} else {
			throw new Exception("Author not found!!");
		}
	}

	/**
	 * This method will - 1. save reader 2. then will set reader in purchasedBook
	 * and 3. will save purchased book into database
	 * 
	 * @param purchasedBook
	 * @return id
	 */
	@PostMapping("/books/{userId}/buy")
	Integer SavePurchasedBook(@Valid @RequestBody Book book, @PathVariable("userId") int userId ) {
		PurchasedBook purchasedBook = new PurchasedBook();
		purchasedBook.setBookId(book.getId());
		User reader = userService.getUserById(userId);
		purchasedBook.setReader(reader);
		return purchasedBookService.savePurchasedBook(purchasedBook).getId();
	}
	
	
	/**
	 * This method will fetch the purchased book according to the email passed
	 * 
	 * @param email
	 * @return list of purchased book
	 */
	@GetMapping("/Readers/{emailId}/books")
	public List<Book> getAllPurchasedBooks(@PathVariable("emailId") String email)throws Exception {
		List<Book> books = purchasedBookService.getPurchasedBook(email);
		if (null!= books) {
			return books;
		}else {
			throw new Exception("books not found!!");
		}
		

	}
	
	@GetMapping("/Readers/books")
	public List<Book>getAllBooks() throws Exception {	
		List<Book> books = (List<Book>) bookService.getBooks();
		if (null!= books) {
			return books;
		}else {
			throw new Exception("books not available!!");
		}
		
	}


}
