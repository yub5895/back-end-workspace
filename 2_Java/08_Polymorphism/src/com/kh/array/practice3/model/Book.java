package com.kh.array.practice3.model;

public class Book {

	private String name;
	private int age;
	public Book() {
	}
	public Book(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", age=" + age + "]";
	}

}