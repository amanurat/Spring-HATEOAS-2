package com.kk.hypermedia.messageconverter;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.kk.hypermedia.dao.StudentDAO;
import com.kk.hypermedia.model.Student;

/**
 * This class is used to convert StudentDAO object into "text/plain" or
 * "text/html" format
 * 
 * @author krishnakumar
 * 
 */
public class StudentMessageConverter extends AbstractHttpMessageConverter<StudentDAO> {
	public StudentMessageConverter() {
		super(new MediaType("text", "plain", Charset.forName("UTF-8")), new MediaType("text", "html", Charset.forName("UTF-8")));
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		return clazz.getSimpleName().equalsIgnoreCase("studentdao");
	}

	@Override
	protected StudentDAO readInternal(Class<? extends StudentDAO> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
		return null;
	}

	@Override
	protected void writeInternal(StudentDAO studentDao, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
		StringBuffer studentRecords = new StringBuffer();
		int count = 1;
		for (Student student : studentDao.getStudentList()) {
			studentRecords.append("\n\nRecord").append(count);
			studentRecords.append("\nId").append(" = ").append(student.getStudentId()).append("\nName").append(" = ").append(student.getStudentName())
					.append("\n").append("Age").append(" = ").append(student.getAge());
			count++;
		}
		outputMessage.getBody().write(studentRecords.toString().getBytes());

	}

}
