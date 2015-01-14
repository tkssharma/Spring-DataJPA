package com.spring.training.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.training.model.Address;
import com.spring.training.model.Student;
import com.spring.training.repository.AddressRepository;
import com.spring.training.repository.StudentRepository;


@Service
@Transactional
@Proxy(lazy = false)
public class StudentService {


	@Autowired
	public StudentRepository studentRepository;


	@Autowired
	public AddressRepository addressRepository;

	public String addstudent(Student student)
	{
		// studentRepository.save();

		Address address= new Address();
		address.setCity(student.getStudentaddress().getCity());
		address.setCountry(student.getStudentaddress().getCountry());
		address.setState(student.getStudentaddress().getState());

		addressRepository.save(address);
		student.setStudentaddress(address);
		studentRepository.save(student);


		return "success";

	}
	@Transactional
	public List<Student> getalistofStudents() {


		return 	studentRepository.findAll();
	}
	@Transactional

	public void removeStudent(Integer id) {
		// TODO Auto-generated method stub
		Student student = getStudentByid(id);
		studentRepository.delete(student);
	}
	@Transactional
	public Student getStudentByid(Integer id) {
		// TODO Auto-generated method stub
		Student student = null;
		List<Student> list = studentRepository.findAll();
		for(int i =0 ;i < list.size() ; i++)
		{
			if(id.toString().equals(list.get(i).getId().toString()))
			{
				student = list.get(i);
			}

		}
		return student;
	}
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
	}




}
