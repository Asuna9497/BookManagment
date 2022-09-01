package com.hnt.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Reader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int readerId;
	
	@NotBlank(message = "emailId cannot be blank#######")
	private String emailId;
	
	private ArrayList<Integer> bookIds;
	
}
