package com.kh.array.practice3.model;

public class rentalBook {
	private boolean coupon;
	private int accessAge;
	private String title;
	
	

	public rentalBook() {
	}

	public rentalBook(String title, boolean coupon, int accessAge) {
		this.coupon = coupon;
		this.accessAge = accessAge;
		this.title = title;
	}

	public boolean isCoupon() {
		return coupon;
	}

	public void setCoupon(boolean coupon) {
		this.coupon = coupon;
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
		return "rentalBook [coupon=" + coupon + ", accessAge=" + accessAge + ", title=" + title + "]";
	}

}
