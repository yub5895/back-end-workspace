package com.kh.example.practice1.model;

import java.util.Objects;

public class Lotto {

	private int number;
	private int number2;
	private int number3;
	private int number4;
	private int number5; 
	private int number6;
	
	public Lotto() {
	}

	public Lotto(int number, int number2, int number3, int number4, int number5, int number6) {
		this.number = number;
		this.number2 = number2;
		this.number3 = number3;
		this.number4 = number4;
		this.number5 = number5;
		this.number6 = number6;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	public int getNumber3() {
		return number3;
	}

	public void setNumber3(int number3) {
		this.number3 = number3;
	}

	public int getNumber4() {
		return number4;
	}

	public void setNumber4(int number4) {
		this.number4 = number4;
	}

	public int getNumber5() {
		return number5;
	}

	public void setNumber5(int number5) {
		this.number5 = number5;
	}

	public int getNumber6() {
		return number6;
	}

	public void setNumber6(int number6) {
		this.number6 = number6;
	}

	@Override
	public String toString() {
		return "Lotto [number=" + number + ", number2=" + number2 + ", number3=" + number3 + ", number4=" + number4
				+ ", number5=" + number5 + ", number6=" + number6 + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, number2, number3, number4, number5, number6);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lotto other = (Lotto) obj;
		return number == other.number && number2 == other.number2 && number3 == other.number3
				&& number4 == other.number4 && number5 == other.number5 && number6 == other.number6;
	}
	
	
	
}
