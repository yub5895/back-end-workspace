package com.kh.polymorphism.model.child;

import com.kh.polymorphism.model.parent.Employee;

public class Engineer extends Employee {

	private String tech;
	private int bonus;
	public Engineer() {
	}
	public Engineer(String name, int salary, String tech, int bonus) {
		super(name, salary);
		this.tech = tech;
		this.bonus = bonus;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		return "Engineer [tech=" + tech + ", bonus=" + bonus + ", name()=" + getName() + ", Salary()="
				+ getSalary() + "]";
	}
	
	
}
