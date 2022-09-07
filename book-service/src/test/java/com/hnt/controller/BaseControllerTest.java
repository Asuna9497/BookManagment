package com.hnt.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.MethodArgumentNotValidException;

@ExtendWith(MockitoExtension.class)
class BaseControllerTest {
	@InjectMocks
	BaseController baseController;

	@Test
	void testHandleOrderNotFound() {
		Exception ex = new Exception();
		assertEquals("something went wrong", baseController.handleBookNotFound(ex));

	}
	
	void testHandleException() {
		MethodArgumentNotValidException ex = new MethodArgumentNotValidException(null, null);
		
		baseController.handleException(ex);
	}

}


