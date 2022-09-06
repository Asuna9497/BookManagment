package com.hnt.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hnt.AuthorRepository;
import com.hnt.entity.Author;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

	@Mock
	AuthorRepository authorRepository;
	
	@InjectMocks
	AuthorService authorService;
	
	@Test
	void testGetAuthorById() {
		Author author = new Author();
		author.setId(1);
		author.setName("Ram");
		
		when(authorRepository.findById(1)).thenReturn(author);
		Author actualAuthor = authorService.getAuthorById(1);	
		assertEquals(author, actualAuthor);
	}
	
	@Test
	void testSaveAuthor() {
		Author author = new Author();
		author.setId(1);
		author.setName("Ram");
		
		when(authorRepository.save(author)).thenReturn(author);
		Author actualAuthor = authorService.saveAuthor(author);
		assertEquals(author, actualAuthor);
	}

}
