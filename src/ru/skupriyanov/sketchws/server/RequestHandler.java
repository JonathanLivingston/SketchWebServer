package ru.skupriyanov.sketchws.server;

import java.io.FileInputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

import ru.skupriyanov.sketchws.model.HttpRequest;

public class RequestHandler {

	public static void handle(final HttpRequest request,
			final OutputStream stream) throws Exception {
		try (FileInputStream fileStream = new FileInputStream(
				"resources/index.html")) {
			IOUtils.copy(fileStream, stream);
		}
		stream.flush();
	}
}
