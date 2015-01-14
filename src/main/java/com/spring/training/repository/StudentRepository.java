package com.spring.training.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.spring.training.model.Student;

@Transactional
public interface StudentRepository  extends JpaRepository<Student, Integer> {

	
}
