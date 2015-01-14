package com.spring.training;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.training.model.Address;
import com.spring.training.model.Student;

import antlr.collections.List;

import java.util.*;

import com.spring.training.services.StudentService;


@Controller
public class AccountController {

	@Autowired
	public StudentService service;

	@RequestMapping(value = "/student.html", method = RequestMethod.GET)
	public ModelAndView show_users(Model model)
	{

		java.util.List<Student> students = service.getalistofStudents();

		for(int i=0;i<students.size() ; i++)
		{
			Student stud= students.get(i);
			Address address= stud.getStudentaddress();
		}

		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("students", students);
		return modelAndView;
	}


	@RequestMapping(value = "/account.html", method = RequestMethod.GET)
	public ModelAndView manage_account(Model model)
	{
		java.util.List<Student> students = service.getalistofStudents();


		ModelAndView modelAndView = new ModelAndView("account");
		modelAndView.addObject("students", students);
		return modelAndView;
	}

	@RequestMapping(value = "/remove/{id}.html", method = RequestMethod.GET)
	public String manage_account_remove(@PathVariable("id") Integer id , Model model)
	{
		service.removeStudent(id);


		return "redirect:/account.html?success=true";
	}

	@RequestMapping(value = "/update/{id}.html", method = RequestMethod.GET)
	public ModelAndView manage_account_update(@PathVariable("id") Integer id , Model model)
	{

		Student student = service.getStudentByid(id);
		System.out.println(""+student);
		ModelAndView modelAndView = new ModelAndView("account");
		modelAndView.addObject("studentdata", student);
		return modelAndView;
	}


	@RequestMapping(value = "/submitupdateddata.html", method = RequestMethod.GET)
	public ModelAndView manage_account_submitupdate(@ModelAttribute ("student1") Student student, Model model)
	{

		service.updateStudent(student);
		ModelAndView modelAndView = new ModelAndView("account");
		modelAndView.addObject("studentdata", student);
		return modelAndView;
	}



}
