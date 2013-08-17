package ru.skupriyanov.sketchws.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.io.IOUtils;

import ru.skupriyanov.sketchws.utils.Constants;

public class Server extends AbstractEntity {
	
	private static final String EXIT_COMMAND = "quit";
	private static final int MAX_BYTE_BUFFER = 2048;

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
		try (InputStream socketInput = socket.getInputStream();
				OutputStream socketOutput = socket.getOutputStream();) {
			while (true) {
				byte[] inputBytes = new byte[MAX_BYTE_BUFFER];
				socketInput.read(inputBytes);
				String message = new String(inputBytes);
				if (EXIT_COMMAND.equals(message)) {
					break;
				}
				System.out.println(message);
				IOUtils.copy(socketInput, socketOutput);
			}
		}
		serverSocket.close();
	}
}
