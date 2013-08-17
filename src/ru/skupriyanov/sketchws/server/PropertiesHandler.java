package ru.skupriyanov.sketchws.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHandler extends AbstractEntity {

	private static final String CONFIG_PATH = "resources/config.properties";
	private static final Properties properties;

	static {
		properties = new Properties();
		try (InputStream propertiesStream = new FileInputStream(new File(
				CONFIG_PATH))) {
			properties.load(propertiesStream);
		} catch (IOException ioException) {
			rootLogger.error(ioException.getMessage(), ioException);
		}
	}

	public static String getPropertyValue(String key) {
		return properties.getProperty(key);
	}

}
