package com.hnt;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hnt.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
	@Query("select author from Author author where author.autherId =?1")
	Author findById(int autherId);

}
