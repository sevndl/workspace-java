package com.sample.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "hello")
public class HelloController {
	
	private String name = "bob";
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
