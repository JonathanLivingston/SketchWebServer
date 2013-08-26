package ru.skupriyanov.sketchws.utils;

public class Constants {

	public static final String PORT_CONFIG_NAME = "port";
	public static final String HTTP_DEFAULT_VERSION = "1.1";
	public static final String CONTENT_LENGTH_HEADER = "Content-Length";

	public enum HttpResponseCode {
		OK("200"), NOT_FOUND("404"), INTERNAL_SERVER_ERROR("500");
		private String errorCode;

		HttpResponseCode(String code) {
			this.errorCode = code;
		}

		public String errorCode() {
			return errorCode;
		}
	}
	
	public enum ResponseHeader {
		CONTENT_TYPE("Content-Type"), CONTENT_LENGTH("Content-Length");
		private String header;
		
		private ResponseHeader(String header) {
			this.header = header;
		}
		
		public String value() {
			return header;
		}
	}
	
	public enum ContentType {
		HTML("text/html"), XML("text/xml");
		
		private String type;
		
		private ContentType(String type) {
			this.type = type;
		}
		
		public String value() {
			return type;
		}
	}
	
	public enum Charset {
		UTF8("utf-8"), CP1251("cp1251");
		
		public static final String PARAM_NAME = "charset";
		private String value;
		
		private Charset(String value) {
			this.value = value;
		}
		
		public String value() {
			return value;
		}
	}

	public enum RequestMethod {
		GET, POST, PUT, DELETE;
	}

	public enum RequestProtocol {
		HTTP, HTTPS;
	}

}
