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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hnt.entity.Author;
import com.hnt.entity.Book;
import com.hnt.entity.Category;
import com.hnt.service.AuthorService;
import com.hnt.service.BookService;

import lombok.extern.slf4j.Slf4j;

/**
 * This is controller class for book
 * 
 * @author priyanka
 *
 */

@Slf4j
@RestController
@RequestMapping("/api/v1/digitalbooks") // TODO: remove api/v1
public class BookController extends BaseController {

	@Autowired
	BookService bookService;

	@Autowired
	AuthorService authorService;

	/**
	 * This method will first fetch the all the books from database then will sort
	 * list according to search parameters
	 * 
	 * @param req
	 * @param res
	 * @return sorted list of book
	 * @throws Exception
	 */
	@GetMapping("/books/search")
	List<Book> getBooks(@RequestParam(value = "category", required = false) String category,
			@RequestParam(value = "author", required = false) String authorName,
			@RequestParam(value = "price", required = false) Float price,
			@RequestParam(value = "publisher", required = false) String publisher){
		log.debug("inside getBooks");
		List<Book> bookList = Streamable.of(bookService.getBooks()).toList();
		List<Book> sortedList = null;
		if (null != bookList) {
			sortedList = bookList.stream()
					.filter(b -> b.getCategory().toString().equalsIgnoreCase(category)
							|| (null != authorName && null != b.getAuthor()
									&& b.getAuthor().getName().equalsIgnoreCase(authorName))
							|| (b.getPrice() == price) || b.getPublisher().equalsIgnoreCase(publisher))
					.collect(Collectors.toList());
		}

		return sortedList;
	}

	/**
	 * This method will - 
	 * 1.find author by id 
	 * 2.set this author in book object
	 * 3.save book object in database
	 * 
	 * @param book
	 * @param authorId
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/author/{authorId}/books")
	Integer saveBook(@Valid @RequestBody Book book, @PathVariable("authorId") int authorId) throws Exception {
		Author author = authorService.getAuthorById(authorId);
		if (null != author) {
			book.setAuthor(author);
			bookService.saveBook(book);
			return book.getId();
		} else {
			throw new Exception("Author not found!!");
		}
	}

}
