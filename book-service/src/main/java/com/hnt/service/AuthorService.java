package com.hnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnt.AuthorRepository;
import com.hnt.entity.Author;

@Service
public class AuthorService {
	
	@Autowired
	AuthorRepository authorRepository;
	
	public Author getAuthorById(int authId){
		 return authorRepository.findById(authId);
	}

}
