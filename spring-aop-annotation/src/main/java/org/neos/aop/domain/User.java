package org.neos.aop.domain;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String lastName;
	private String email;
	
	public User(){
	}
	public User(String name,String lastName,String email){
		this.name=name;
		this.lastName=lastName;
		this.email=email;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString(){
		StringBuilder cadena = new StringBuilder();
		cadena.append("Name: ").append(this.name).append(" ");
		cadena.append("Lastname: ").append(this.lastName).append(" ");
		cadena.append("Email: ").append(this.email);
		return cadena.toString();
	}

}
