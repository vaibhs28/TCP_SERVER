package exception;

public class InvalidSyntaxException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidSyntaxException(String msg) {
		super(msg);
	}
 
	public InvalidSyntaxException(String msg, Throwable t) {
		super(msg, t);
	}
}
