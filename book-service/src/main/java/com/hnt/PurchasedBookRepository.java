package com.hnt;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hnt.entity.PurchasedBook;

public interface PurchasedBookRepository extends JpaRepository<PurchasedBook, Integer> {

}
