package com.kh.array.practice3.controller;

import java.util.ArrayList;

import com.kh.array.practice3.model.Book;
import com.kh.array.practice3.model.rentalBook;


public class BookController<bookList> {

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

	public void books() {
		ArrayList<rentalBook> list = new ArrayList<rentalBook>();
		list.add(new rentalBook("밥을 지어요", true, 0));
		list.add(new rentalBook("오늘은 아무래도 덮밥", false, 0));
		list.add(new rentalBook("원피스 108", false, 15));
		list.add(new rentalBook("귀멸의 칼날 23", false, 19));

		System.out.println(list);
	}
	
	public Book my() {
		return book;
	}
}