package com.kk.hypermedia.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.kk.hypermedia.model.Student;

/**
 * @author krishnakumar
 * 
 */
@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class StudentDAO {
	@XmlElement(name = "student")
	private List<Student> studentList = new ArrayList<Student>();

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	/**
	 * This method will be called automatically to setup some in-memory objects
	 */
	@PostConstruct
	public void init() {
		Student student = new Student();
		student.setStudentId("1");
		student.setStudentName("Kumar");
		student.setAge("20");
		studentList.add(student);

		student = new Student();
		student.setStudentId("2");
		student.setStudentName("Ram");
		student.setAge("21");
		studentList.add(student);

		student = new Student();
		student.setStudentId("3");
		student.setStudentName("Raj");
		student.setAge("22");
		studentList.add(student);
		student = new Student();
		student.setStudentId("4");
		student.setStudentName("Ragu");
		student.setAge("21");
		studentList.add(student);
		System.out.println(studentList);
	}
}
