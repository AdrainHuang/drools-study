package com.drools.ch3;

import lombok.Data;

/**
 * @Author AdrainHuang
 * @Date 2019/6/15 17:08
 **/
@Data
public class Car {
	private String name;
	private Double price;
	private Double finalPrice;
	private Person person;
	
	public Car(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	public Car() {
	}
}
