package com.sulek.bezpecnost.Exceptions;

import javax.validation.constraints.Min;

public class BookNotFoundException extends Exception {

	public BookNotFoundException(@Min(1) Long id) {
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8022456833109172709L;

}
