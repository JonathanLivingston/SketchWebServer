package ru.skupriyanov.sketchws.utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.skupriyanov.sketchws.model.HttpRequest;
import ru.skupriyanov.sketchws.utils.Constants.RequestMethod;
import ru.skupriyanov.sketchws.utils.Constants.RequestProtocol;
import ru.skupriyanov.sketchws.utils.exception.HttpRequestParseException;

public class RequestParser {

	private static final Pattern HEADER_PATTERN = Pattern
			.compile("(\\w+) / (\\w+)/(\\d.\\d)");
	private static final Pattern VALUE_PATTERN = Pattern.compile("(.+): (.+)");

	public static HttpRequest parseStream(final Scanner scanner)
			throws HttpRequestParseException {
		HttpRequest request = new HttpRequest();
		String header = scanner.nextLine();
		Matcher headerMatcher = HEADER_PATTERN.matcher(header);
		if (!headerMatcher.matches()) {
			throw new HttpRequestParseException(
					HttpRequestParseException.HEADER_DOES_NOT_MATCH);
		} else {
			request.setMethod(RequestMethod.valueOf(headerMatcher.group(1)));
			request.setProtocol(RequestProtocol.valueOf(headerMatcher.group(2)));
		}
		while (scanner.hasNextLine()) {
			String valueString = scanner.nextLine();
			Matcher valueMatcher = VALUE_PATTERN.matcher(valueString);
			if (valueMatcher.matches()) {
				request.putValue(valueMatcher.group(1), valueMatcher.group(2));
			} else {
				break;
			}
		}
		return request;
	}
}
