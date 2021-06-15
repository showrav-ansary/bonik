package com.showrav.bonik.exceptions;

public class OptimisticLockingFailureException extends RuntimeException {
	public OptimisticLockingFailureException(String msg) {
		super(msg);
	}
}
