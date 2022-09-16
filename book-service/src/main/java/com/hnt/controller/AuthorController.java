package com.hnt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hnt.entity.Author;
import com.hnt.service.AuthorService;

/**
 * This is author controller class which have method to save the Author
 * 
 * @author priyanka
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/api/v1/digitalbooks/author")
public class AuthorController extends BaseController {
	@Autowired
	AuthorService authorService;

	/**
	 * This method will save author and return the id
	 * 
	 * @param author
	 * @return id
	 */
	@PostMapping("/signup")
	Integer saveAuthor(@Valid @RequestBody Author author) {
		return authorService.saveAuthor(author).getId();
	}

}
