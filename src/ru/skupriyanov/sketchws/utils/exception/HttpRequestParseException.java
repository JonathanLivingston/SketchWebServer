package ru.skupriyanov.sketchws.utils.exception;

@SuppressWarnings("serial")
public class HttpRequestParseException extends Exception {
	
	public static final String HEADER_DOES_NOT_MATCH = "Unparseable header";

	public HttpRequestParseException(String message) {
		super(message);
	}
	
}
