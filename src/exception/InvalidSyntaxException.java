package exception;

public class InvalidSyntaxException extends Exception {

	public InvalidSyntaxException(String msg) {
		super(msg);
	}
 
	public InvalidSyntaxException(String msg, Throwable t) {
		super(msg, t);
	}
}
