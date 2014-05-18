package com.kk.hypermedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kk.hypermedia.dao.StudentDAO;
import com.kk.hypermedia.model.Student;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private transient StudentDAO studentdao;

	@RequestMapping(value = "/all")
	public ResponseEntity<StudentDAO> getStudentDetails() {
		return new ResponseEntity<StudentDAO>(studentdao, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", produces = { "application/xml", "application/json" })
	public ResponseEntity<Student> getStudent(@PathVariable String id) {
		Student student = studentdao.getStudentList().get(Integer.parseInt(id));
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

}
