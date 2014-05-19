package com.kk.hypermedia.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author krishnakumar
 * 
 */
@XmlRootElement(name = "student")
@JsonInclude(Include.NON_EMPTY)
public class Student extends ResourceSupport {

	@JsonProperty("regNo")
	private String studentId;
	@JsonProperty("name")
	private String studentName;
	@JsonProperty("age")
	private String age;

	@XmlElement(name = "regNo")
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@XmlElement(name = "name")
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@XmlElement(name = "age")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
