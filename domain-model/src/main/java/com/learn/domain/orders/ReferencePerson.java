package com.learn.domain.orders;

import com.learn.domain.commons.concept.ValueObject;

public class ReferencePerson implements ValueObject{
	private String firstName;
	private String lastName;
	
	
	public ReferencePerson(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
}
