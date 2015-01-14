package com.spring.training.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Student {

	@Id
	@GeneratedValue
	private Integer id;
    
	@Email @NotNull
	public String email;  
	@Size( min=6 , max=20)
	public String name;
	@Size( min=6 , max=20)
	public String password;
	@NotNull
	public Long mobno;
	
	public Date dob;
	
	@OneToOne(mappedBy="student")
	public Address studentaddress;

   
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getMobno() {
		return mobno;
	}
	public void setMobno(Long mobno) {
		this.mobno = mobno;
	}
	public Address getStudentaddress() {
		return studentaddress;
	}
	public void setStudentaddress(Address studentaddress) {
		this.studentaddress = studentaddress;
	}



}
