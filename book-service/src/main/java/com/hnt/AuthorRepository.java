package com.hnt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hnt.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	@Query("select author from Author author where author.id =?1")
	Author findById(int autherId);

}
