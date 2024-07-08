package com.kh.array.practice3.model;

public class Book {

	private String name;
	private String Book;
	private int age;
	private boolean coupon;
	private String bookList;
	private int accessAge;
	private String title;
	public Book() {
	}
	public Book(String name, String book, int age, boolean coupon, String bookList, int accessAge) {
		this.title = title;
		this.name = name;
		Book = book;
		this.age = age;
		this.coupon = coupon;
		this.bookList = bookList;
		this.accessAge = accessAge;
	}
	public Book(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBook() {
		return Book;
	}
	public void setBook(String book) {
		Book = book;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isCoupon() {
		return coupon;
	}
	public void setCoupon(boolean coupon) {
		this.coupon = coupon;
	}
	public String getBookList() {
		return bookList;
	}
	public void setBookList(String bookList) {
		this.bookList = bookList;
	}
	public int getAccessAge() {
		return accessAge;
	}
	public void setAccessAge(int accessAge) {
		this.accessAge = accessAge;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", Book=" + Book + ", age=" + age + ", coupon=" + coupon + ", bookList="
				+ bookList + ", accessAge=" + accessAge + ", title=" + title + "]";
	}
	
	public void Book1(String title, boolean coupon, int accessAge) {
		title = "밥을 지어요";
		coupon = true;
		accessAge = 0;
	}
	
}
