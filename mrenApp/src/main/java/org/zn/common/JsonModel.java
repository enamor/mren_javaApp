package org.zn.common;

import org.zn.common.Response;

public class JsonModel {
	private int code;
	private String message;
	private Object data;

	public JsonModel(){
		this.code = Response.SC_OK;
		this.message = Response.SC_OK_MESSAGE;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
