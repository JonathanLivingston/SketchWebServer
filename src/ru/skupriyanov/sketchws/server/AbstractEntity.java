package ru.skupriyanov.sketchws.server;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class AbstractEntity {

	private static final String FILE_LOGGERN_NAME = "logfile";
	private static final String CONFIG_FILE_NAME = "log4j.properties";

	static {
		PropertyConfigurator.configure(CONFIG_FILE_NAME);
	}

	protected static final Logger rootLogger = Logger.getRootLogger();
	protected static final Logger fileLogger = Logger
			.getLogger(FILE_LOGGERN_NAME);

}
