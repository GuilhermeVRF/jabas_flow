package utils;

public class Response<T> {
	private final String STATUS;
	private final String MESSAGE;
	private final T DATA;
	
	public Response(String status, String message) {
		this.STATUS = status;
		this.MESSAGE = message;
		this.DATA = null;
	}
	
	public Response(String status, String message, T data) {
		this.STATUS = status;
		this.MESSAGE = message;
		this.DATA = data;
	}
	
	public String getSTATUS() {
		return STATUS;
	}

	public String getMESSAGE() {
		return MESSAGE;
	}
	
	public T getDATA() {
		return this.DATA;
	}
}
