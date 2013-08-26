package ru.skupriyanov.sketchws.server;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import ru.skupriyanov.sketchws.model.HttpRequest;
import ru.skupriyanov.sketchws.utils.Constants;
import ru.skupriyanov.sketchws.utils.RequestParser;

public class Server extends AbstractService {

	public static void main(String[] args) {
		Server server = new Server();
		try {
			server.initialize();
		} catch (Exception exception) {
			rootLogger.error(exception.getMessage(), exception);
		}
	}

	private void initialize() throws Exception {
		ServerSocket serverSocket = new ServerSocket(
				Integer.parseInt(PropertiesHandler
						.getPropertyValue(Constants.PORT_CONFIG_NAME)));
		Socket socket = serverSocket.accept();
		try (Scanner inputStreamScanner = new Scanner(socket.getInputStream());
				OutputStream socketOutput = socket.getOutputStream();) {
			HttpRequest request = RequestParser.parseStream(inputStreamScanner);
			if (request != null) {
				RequestHandler.handle(request, socketOutput);
			}
		}
		serverSocket.close();
	}
}
