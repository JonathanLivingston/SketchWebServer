package ru.skupriyanov.sketchws.model;

import java.util.HashMap;
import java.util.Map;

import ru.skupriyanov.sketchws.utils.Constants.RequestMethod;
import ru.skupriyanov.sketchws.utils.Constants.RequestProtocol;

public class HttpRequest {
	
	private Map<String, String> values;
	private RequestMethod method;
	private RequestProtocol protocol;
	
	public HttpRequest() {
		setValues(new HashMap<String, String>());
	}
	
	public void putValue(String key, String value) {
		this.values.put(key, value);
	}
	
	public String getValue(String key) {
		return this.values.get(key);
	}

	public Map<String, String> getValues() {
		return values;
	}

	public void setValues(Map<String, String> values) {
		this.values = values;
	}
	
	public String getValues(String key) {
		return values.get(key);
	}

	public RequestMethod getMethod() {
		return method;
	}

	public void setMethod(RequestMethod method) {
		this.method = method;
	}

	public RequestProtocol getProtocol() {
		return protocol;
	}

	public void setProtocol(RequestProtocol protocol) {
		this.protocol = protocol;
	}

}
