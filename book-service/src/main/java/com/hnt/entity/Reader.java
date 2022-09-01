package com.hnt.entity;

import java.util.ArrayList;

import javax.persistence.Entity;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Reader {

	@NotBlank(message = "emailId cannot be blank#######")
	private String name;

	@NotBlank(message = "emailId cannot be blank#######")
	private String emailId;
		
}
