package com.hnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnt.AuthorRepository;
import com.hnt.entity.Author;

/**
 * this is author service class which have below two methods: 
 * 1. getAuthorById(): will find author by id 
 * 2. saveAuthor(): will save author
 * 
 * @author priyanka
 *
 */

@Service
public class AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	/**
	 * This method will find author by id and will return author object
	 * 
	 * @param authId
	 * @return Author
	 */
	public Author getAuthorById(int id) {
		return authorRepository.findById(id);
	}

	/**
	 * This method will save author in database
	 * 
	 * @param author
	 * @return Author
	 */
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}

}
