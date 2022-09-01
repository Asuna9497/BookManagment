package com.hnt.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hnt.entity.Author;
import com.hnt.entity.Book;
import com.hnt.service.AuthorService;
import com.hnt.service.BookService;

@RestController
@RequestMapping("/api/v1/digitalbooks")
public class BookController extends BaseController {

	@Autowired
	BookService bookService;

	@Autowired
	AuthorService authorService;

	@GetMapping("/books/search")
	ArrayList<Book> getBooks(@PathVariable("category") String category, @PathVariable("author") String Author,
			@PathVariable("price") int price, @PathVariable("publisher") String publisher) {
		Iterable<Book> bookList = bookService.getBooks();
		ArrayList<Book> result = new ArrayList<>();
		for (Book b : bookList) {
			if (b.getCategory().equalsIgnoreCase(category) || b.getAuthor().equalsIgnoreCase(Author)
					|| b.getPrice() == price || b.getPublisher().equalsIgnoreCase(publisher)) {
				result.add(b);
			}
		}

		return result;
	}

	@PostMapping("/author/{authorId}/books")
	Integer saveBook(@Valid @RequestBody Book book, @PathVariable("authorId") int authorId) {
//		Author author = authorService.getAuthorById(authorId);
//		if (null != author) {
//			book.setAuthor(author.getAutherName());
//		} else {
//			book.setAuthor("abc");
//		}
		bookService.saveBook(book);
		return book.getBookId();
	}

}
