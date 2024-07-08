package com.kh.array.practice3.controller;

import com.kh.array.practice3.model.Book;

public class BookController {

	private Book book = new Book();
	
	public void rentalBook(String title, boolean coupon, int accessAge) {
		book.setTitle(title);
		book.setCoupon(coupon);
		book.setAccessAge(accessAge);
	}
	
	public void myPageBook(String title, String name, int age, String bookList, boolean coupon, int accessAge) {
		book.setTitle(title);
		book.setName(name);
		book.setAge(age);
		book.setBookList(bookList);
		book.setCoupon(coupon);
		book.setAccessAge(accessAge);
		
	}
}
