package com.nickjojo.ecomapp.entity;

public enum Role {

	USER("USER"),
	ADMIN("ADMIN");
	
	private String name;
	
	Role(String name) {
		this.name = name;
	}
}
