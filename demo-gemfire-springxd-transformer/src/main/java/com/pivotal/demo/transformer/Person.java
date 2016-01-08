package com.pivotal.demo.transformer;

import java.io.Serializable;

public class Person implements Serializable {
	private String id;
	private String email;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String personId) {
		this.id = personId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
