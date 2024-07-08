package com.kh.polymorphism.model.child;

import com.kh.polymorphism.model.parent.Employee;

public class Manager extends Employee{
	
	private String dept;

	public Manager() {
	}

	public Manager(String name, int salary, String dept) {
		super(name, salary);
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Manager [dept=" + dept + ", name()=" + getName() + ", salary()=" + getSalary() + "]";
	}
	
	
}
