package utils;

public class Response {
	private final String STATUS;
	private final String MESSAGE;
	
	public Response(String status, String message) {
		this.STATUS = status;
		this.MESSAGE = message;
	}
	
	public String getSTATUS() {
		return STATUS;
	}

	public String getMESSAGE() {
		return MESSAGE;
	}
}
