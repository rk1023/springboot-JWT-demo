package com.rk.todo.dtos;

public class BasicAuthDTO {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BasicAuthDTO(String message) {
		super();
		this.message = message;
	}
	

}
