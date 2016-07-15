package com.project.application.exception;

public class ApplicationException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public ApplicationException(String message){
		super(message);
		this.message = message;
	}
	
	@Override
	public String getMessage(){
		return this.message;
	}
}