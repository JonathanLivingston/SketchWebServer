package ru.skupriyanov.sketchws.server;

import java.io.OutputStream;

import ru.skupriyanov.sketchws.model.HttpRequest;
import ru.skupriyanov.sketchws.utils.Constants;

public class RequestHandler {

	public static void handle(final HttpRequest request,
			final OutputStream stream) throws Exception {
		String responseMessage = "<!DOCTYPE html><html><body><h1>Response Page Header</h1><p>Response Page Body</p></body></html>";
		StringBuilder response = new StringBuilder();
		// HTTP/1.1 200 OK
		response.append(request.getProtocol().name()).append('/')
				.append(Constants.HTTP_DEFAULT_VERSION).append(' ')
				.append(Constants.HttpResponseCode.OK.errorCode()).append(' ')
				.append(Constants.HttpResponseCode.OK.name()).append('\r')
				.append('\n');
		// Content-Type: text/html;charset=utf-8
		response.append(Constants.ResponseHeader.CONTENT_TYPE.value())
				.append(':').append(Constants.ContentType.HTML.value())
				.append(';').append(Constants.Charset.PARAM_NAME).append('=')
				.append(Constants.Charset.UTF8.value()).append('\r')
				.append('\n');
		// Content-Length: %n
		response.append(Constants.CONTENT_LENGTH_HEADER).append(':')
				.append(String.valueOf(responseMessage.getBytes().length))
				.append('\r').append('\n').append('\r').append('\n');
		response.append(responseMessage);

		stream.write(response.toString().getBytes());
		stream.flush();
	}
}
