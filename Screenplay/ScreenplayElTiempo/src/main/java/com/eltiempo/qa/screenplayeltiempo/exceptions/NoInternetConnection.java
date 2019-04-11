package com.eltiempo.qa.screenplayeltiempo.exceptions;

public class NoInternetConnection extends AssertionError {
	
	private static final String NO_NETWORK_MESSAGE = "Without connection to the network";

	public static String getErrorNetworkMessage() {
		return NO_NETWORK_MESSAGE;
	}
	
	public NoInternetConnection(String message, Throwable cause) {
		super(message, cause);
	}

}
