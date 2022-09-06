package com.hnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnt.ReaderRepository;
import com.hnt.entity.Reader;

/**
 * This is reader service class which will save the reader
 * 
 * @author priyanka
 *
 */
@Service
public class ReaderService {

	@Autowired
	ReaderRepository readerRepository;

	/**
	 * This method will save reader in database
	 * 
	 * @param reader
	 * @return Reader
	 */
	public Reader saveReader(Reader reader) {
		return readerRepository.save(reader);
	}

}