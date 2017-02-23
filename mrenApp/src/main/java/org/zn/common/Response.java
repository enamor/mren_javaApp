package org.zn.common;

public class Response {
	/**
     * Status code (200) indicating the request succeeded normally.
     */
    public static final int SC_OK = 200;
    public static final String SC_OK_MESSAGE = "success";
    
    /**
     * Status code (400) indicating the request sent by the client was
     * syntactically incorrect.
     */
    public static final int SC_BAD_REQUEST = 400;
    public static final String SC_BAD_MESSAGE = "failure";
}
