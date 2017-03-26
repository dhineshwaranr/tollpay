package com.toll.dto;

import java.util.Set;

public class UserDto {

	private Long id;
	private String firstName;
	private String lastName;
	private int age;
	
	public UserDto(Long id, String firstName, String lastName,int age) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
