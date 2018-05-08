package com.nish.salesprocessor.exception;
/**
 * Sale processing exception
 * @author n.mathew.joy
 *
 */
public class SalesProcessorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message
	 */
	public SalesProcessorException(String message) {
		super(message);
	}

	public SalesProcessorException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
