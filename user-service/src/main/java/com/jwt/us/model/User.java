package com.jwt.us.model;

public class User {

	private String name;
	private String lastName;
	private Integer age;
	private Character genre;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Character getGenre() {
		return genre;
	}

	public void setGenre(Character genre) {
		this.genre = genre;
	}

}
