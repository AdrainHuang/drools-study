package com.drools.ch3;

import lombok.Data;

import java.util.List;

/**
 * @Author AdrainHuang
 * @Date 2019/6/15 17:14
 **/
@Data
public class Person {
	private String name;
	private int age;
	private List<Car> cars;
	
	public Person() {
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
