package com.spring.training.services;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.training.model.Address;
import com.spring.training.model.Student;
import com.spring.training.repository.AddressRepository;
import com.spring.training.repository.StudentRepository;


@Service
@Transactional
public class InitService {
	
	
	@Autowired
	public StudentRepository studentRepository;
	
	@Autowired
	public AddressRepository addressRepository;
	
	
	@PostConstruct
	public void init()
	{
		

		Address address= new Address();
		address.setCity("jaipur");
		address.setCountry("india");
		address.setState("harynaa");
		
		
		Student student = new Student();
		student.setName("Tarunkumar");
		student.setPassword("hellohello");
		student.setEmail("hello@gmail.com");
		student.setDob(new Date());
		student.setMobno((long) 2324);
		addressRepository.save(address);
		student.setStudentaddress(address);
		studentRepository.save(student);
		
		
	}

}
