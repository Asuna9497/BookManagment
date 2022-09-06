package com.hnt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * This is bean class for reader
 * 
 * @author priyanka
 *
 */
@Data
@Entity
public class Reader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotBlank(message = "name cannot be blank#######")
	private String name;

	@Email(message = "email should be in correct format")
	private String email;
}