package com.intuit.task.score.customer.services;

public class MatchException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public MatchException(String errorMessage, Throwable err) {
	    super(errorMessage, err);
	}

}
