package com.kh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor
public class member {

	private int no;
	private String id; 
	private String pwd;
	private String name;
	private char gender;
	private String address;
	private String phone;
	private char status;
	private String enroll_date;
}
