package com.hnt.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * This is bean class for book
 * 
 * @author priyanka
 *
 */
@Data
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotBlank(message = "logo cannot be blank#######")
	private String logo;

	@NotBlank(message = "title cannot be blank#######")
	private String title;
	
	@Enumerated(EnumType.STRING)
	private Category category;

	@Min(value = 1, message = "price cannot be less than 1")
	private float price;
	
	@ManyToOne
	private User author;

	@NotBlank(message = "publisher cannot be blank#######")
	private String publisher;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate publishedDate;

	@NotBlank(message = "content cannot be blank#######")
	private String content;

	private boolean active;

}
