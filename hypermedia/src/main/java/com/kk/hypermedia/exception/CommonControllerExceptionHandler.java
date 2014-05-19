package com.kk.hypermedia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author krishnakumar
 * 
 */
@ControllerAdvice
public class CommonControllerExceptionHandler {

	/**
	 * This methos is used to handle all the HypermediaExceptions
	 * 
	 * @param ex
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(HypermediaException.class)
	public ResponseEntity<String> handleHypermediaException(HypermediaException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NO_CONTENT);
	}

	/**
	 * This method is used to handle only method not allowed exception Example
	 * some method supports only GET but we will used POST to call method
	 * 
	 * @param ex
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<String> handleNotSupportedExceptions(HttpRequestMethodNotSupportedException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
	}

	/**
	 * This method is used to handle all the exceptions which are the sub type
	 * of Exception.class
	 * 
	 * @param ex
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleAllExceptions(Exception ex) {
		ex.printStackTrace();
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
	}
}
