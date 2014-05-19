package com.kk.hypermedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kk.hypermedia.dao.StudentDAO;
import com.kk.hypermedia.exception.HypermediaException;
import com.kk.hypermedia.model.Student;

/**
 * @author krishnakumar
 * 
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private transient StudentDAO studentdao;

	/**
	 * This method is used to get all the student details and this /all will
	 * supports only the type which are present in produces{} block
	 * 
	 * @return ResponseEntity<StudentDAO>
	 */
	@RequestMapping(value = "/all", produces = { "text/plain", "text/html", "application/xml", "application/json" })
	public ResponseEntity<StudentDAO> getStudentDetails() {
		return new ResponseEntity<StudentDAO>(studentdao, HttpStatus.OK);
	}

	/**
	 * This method is used to get only particular student detail.
	 * 
	 * @param id
	 * @return ResponseEntity<StudentDAO>
	 * @throws HypermediaException
	 */
	@RequestMapping(value = "/{id}", produces = { "application/xml", "application/json" }, method = { RequestMethod.GET })
	public ResponseEntity<Student> getStudent(@PathVariable String id) throws HypermediaException {
		final Student student = studentdao.getStudentList().get(Integer.parseInt(id));
		if (student == null) {
			throw new HypermediaException("No student found");
		}
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

}
