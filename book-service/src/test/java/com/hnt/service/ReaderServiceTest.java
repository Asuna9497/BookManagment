package com.hnt.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hnt.ReaderRepository;
import com.hnt.entity.Reader;

@ExtendWith(MockitoExtension.class)
class ReaderServiceTest {
	@InjectMocks
	ReaderService readerService;
	
	@Mock
	ReaderRepository readerRepository;

	@Test
	void testSaveReader() {
		Reader reader = new Reader();
		reader.setId(1);
		reader.setName("Vaibhav");
		reader.setEmail("vaibhav.v@v.com");
		when(readerRepository.save(reader)).thenReturn(reader);
		assertEquals(1, readerService.saveReader(reader).getId());
	}

}
