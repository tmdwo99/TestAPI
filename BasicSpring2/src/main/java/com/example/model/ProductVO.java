package com.example.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProductVO {
	private String name;
	private double price;
	
	public ProductVO(String name, double price) 
	{
		this.name=name;
		this.price=price;
	}
}	
