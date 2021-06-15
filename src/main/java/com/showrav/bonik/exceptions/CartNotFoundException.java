package com.showrav.bonik.exceptions;

public class CartNotFoundException extends RuntimeException {
	public CartNotFoundException(String msg) {
		super(msg);
	}
}
