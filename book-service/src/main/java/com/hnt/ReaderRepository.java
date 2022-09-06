package com.hnt;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hnt.entity.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Integer> {

}
