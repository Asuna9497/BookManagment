package com.hnt;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hnt.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
