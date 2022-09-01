package com.hnt;

import org.springframework.data.repository.CrudRepository;

import com.hnt.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

}
