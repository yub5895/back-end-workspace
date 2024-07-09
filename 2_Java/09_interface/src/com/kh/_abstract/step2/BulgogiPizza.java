package com.kh._abstract.step2;

public  class BulgogiPizza extends Pizza{

	public BulgogiPizza(int price, String brand) {
		super(price, brand);
	}

	@Override
	public void info() {
		System.out.println(brand + "의 포테이토 피자 " + price + "원");
		
	}

	@Override
	public void topping() {
		System.out.println("토핑은 불고기를 포함시킨다.");
		
	}

	
}
