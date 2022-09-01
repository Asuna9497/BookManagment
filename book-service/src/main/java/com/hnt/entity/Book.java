package com.hnt.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	
	@NotBlank(message = "logo cannot be blank#######")
	private String logo;
	
	@NotBlank(message = "title cannot be blank#######")
	private String title;
	
	@NotBlank(message = "category cannot be blank#######")
	private String category;
	
	@Min(value = 1, message = "price cannot be less than 1")
	private int price;
	
	private String author;
	
	@NotBlank(message = "publisher cannot be blank#######")
	private String publisher;
	
	//@JsonFormat(pattern = "MM/dd/yyyy")
	private String publishedDate;
	
	@NotBlank(message = "content cannot be blank#######")
	private String content;
	
	private boolean active;

}
