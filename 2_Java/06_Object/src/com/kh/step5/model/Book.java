package com.kh.step5.model;

public class Book {

	/*
	 * 캡슐화(Encapsulation) - 정보은닉 : 외부에서 객체 접근하는데 있어서 정보를 숨기고 객체의 연산을 통해서만 접근이 가능하게
	 * 하는 것 - 객체 내 정보손상, 오용을 방지하고, 데이터가 변경되어도 다른 객체에 영향을 주지 X - 독립성이 좋고, 하나의 모듈처럼
	 * 사용이 가능
	 */
	private String title;
	private int price;
	private double discountRate;
	private String author;

	public Book() {
	}

	public Book(String title, int price, double discountRate, String author) {// ALT SHIFT S
		this.title = title;
		this.price = price;
		this.discountRate = discountRate;
		this.author = author;
	}

	// getter, setter
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() { // ALT SHIFT S -> Generation toString 누르면 자동생성
		return "Book [title=" + title + ", price=" + price + ", discountRate=" + discountRate + ", author=" + author
				+ "]";
	}

	public int getPrice() {
		return price;
	}

	public void setAuthor(String string) {
		// TODO Auto-generated method stub

	}

	public void setPrice(int i) {
		// TODO Auto-generated method stub

	}

	public void setDiscountPrice(double d) {
		// TODO Auto-generated method stub

	}

	public int getDiscountRate() {
		// TODO Auto-generated method stub
		return 0;
	}

}