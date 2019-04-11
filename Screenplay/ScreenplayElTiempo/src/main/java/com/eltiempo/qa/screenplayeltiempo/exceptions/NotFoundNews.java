package com.eltiempo.qa.screenplayeltiempo.exceptions;

public class NotFoundNews extends AssertionError{
	private static final String NEWS_NOT_FOUND = "News not found";

	public static String newsNotFound() {
		return NEWS_NOT_FOUND;
	}
	
	public NotFoundNews(String message, Throwable cause) {
		super(message, cause);
	}
}
