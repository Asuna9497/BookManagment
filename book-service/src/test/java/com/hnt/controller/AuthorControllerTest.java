package com.hnt.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hnt.entity.Author;
import com.hnt.service.AuthorService;

@ExtendWith(MockitoExtension.class)
class AuthorControllerTest {
	@Mock
	AuthorService authorService;
	
	@InjectMocks
	AuthorController authorController;

	@Test
	void testSaveAuthor() {
		Author author = new Author();
		author.setId(1);
		author.setName("Ram");
		
		when(authorService.saveAuthor(author)).thenReturn(author);
		int savedAuthorId = authorController.saveAuthor(author);
		assertEquals(1, savedAuthorId);
	}

}
