package com.showrav.bonik.util;

public class StringUtil {
	public static boolean isNotEmpty(String value) {

		return !isEmpty(value);
	}

	public static boolean isEmpty(String value) {

		return value == null || value.length() == 0;
	}
}
