package com.hnt;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hnt.entity.PurchasedBooks;

public interface PurchasedBooksRepository extends JpaRepository<PurchasedBooks, Integer> {

}
