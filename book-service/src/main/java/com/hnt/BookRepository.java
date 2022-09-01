package com.hnt;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hnt.entity.Book;

public interface BookRepository extends JpaRepository <Book, Integer>{
	
	@Query("select book from Book book where book.category=?1 or book.author=?2 or book.price=?3"
			+ " or book.publisher=?4")
	List<Book> searchBook(String category, String author, int price, String publisher);

}
