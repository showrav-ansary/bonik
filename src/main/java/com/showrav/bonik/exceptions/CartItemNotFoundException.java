package com.showrav.bonik.exceptions;

public class CartItemNotFoundException extends RuntimeException {
	public CartItemNotFoundException() {
	}

	public CartItemNotFoundException(String message) {
		super(message);
	}
}
