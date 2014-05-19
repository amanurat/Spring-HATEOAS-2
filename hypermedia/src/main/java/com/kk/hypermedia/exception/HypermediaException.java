package com.kk.hypermedia.exception;

/**
 * @author krishnakumar
 * 
 */
public class HypermediaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HypermediaException() {
		super();
	}

	public HypermediaException(String message) {
		super(message);
	}

	public HypermediaException(String message, Throwable t) {
		super(message, t);
	}

}
