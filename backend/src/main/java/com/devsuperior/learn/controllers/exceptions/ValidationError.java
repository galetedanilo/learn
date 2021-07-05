package com.devsuperior.learn.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> error = new ArrayList<>();
	
	public List<FieldMessage> getValidationErrors() {
		return error;
	}
	
	public void addValidationError(String fieldName, String message) {
		error.add(new FieldMessage(fieldName, message));
	}
}
