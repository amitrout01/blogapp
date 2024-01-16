package com.blogapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ResourceNotFoundException extends RuntimeException{
	private long id;
	public ResourceNotFoundException(long id) {
		super("ResouceNotFoundException: "+ id);
	}

}
