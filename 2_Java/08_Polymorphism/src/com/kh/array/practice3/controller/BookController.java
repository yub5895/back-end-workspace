package com.kh.array.practice3.controller;

import com.kh.array.practice3.model.Book;
import com.kh.array.practice3.model.rentalBook;


public class BookController {

	private Book book = new Book();
	private rentalBook bookList = new rentalBook();
	
	public void bookList(String title, boolean coupon, int accessAge) {
		bookList.setTitle(title);
		bookList.setCoupon(coupon);
		bookList.setAccessAge(accessAge);
	}
	
	public void myPageBook(String name, int age ) {

		book.setName(name);
		book.setAge(age);
	
	}
	

}
