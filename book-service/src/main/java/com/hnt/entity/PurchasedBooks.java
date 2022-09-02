package com.hnt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import lombok.Data;

@Data
@Entity
public class PurchasedBooks {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	
	@Min(value = 1, message="bookId cannot be less than 1")
	private int bookId;

	@ManyToOne
	private Reader reader;

}
