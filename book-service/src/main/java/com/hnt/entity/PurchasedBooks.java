package com.hnt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class PurchasedBooks {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	
	private int bookId;
	
	@ManyToOne
	private Reader reader;
	

}
