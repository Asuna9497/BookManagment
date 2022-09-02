package com.hnt.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/digitalbooks")
public class BookController extends BaseController {

	@Autowired
	BookService bookService;

	@Autowired
	AuthorService authorService;

	@GetMapping("/books/search")
	List<Book> getBooks(HttpServletRequest req, HttpServletResponse res) {		
		log.debug("inside getBooks");
		String category = req.getParameter("category");
		String authorName = req.getParameter("author");
		int price = Integer.valueOf(req.getParameter("price"));
		String publisher = req.getParameter("publisher");

		List<Book> bList = Streamable.of(bookService.getBooks()).toList();
		List<Book> sortedList = null;

		if (null != bList) {
			sortedList = bList.stream()
					.filter(b -> b.getCategory().equalsIgnoreCase(category) || b.getAuthor().getName().equalsIgnoreCase(authorName)
							|| b.getPrice() == price || b.getPublisher().equalsIgnoreCase(publisher))
					.collect(Collectors.toList());
		}
		
		return sortedList;
	}

	@PostMapping("/author/{authorId}/books")
	Integer saveBook(@Valid @RequestBody Book book, @PathVariable("authorId") int authorId) {
		Author author = authorService.getAuthorById(authorId);
		if (null != author) {
			book.setAuthor(author);
		}
		bookService.saveBook(book);
		return book.getBookId();
	}

}
