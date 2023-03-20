package exercise;

public class InvalidURLException extends Exception{
	private String messageString = "the input url has invalid Exception";
	
	public InvalidURLException(String message) {
		this.messageString = message;
	}
	
	public String getMessage() {
		return messageString;
	}
}
