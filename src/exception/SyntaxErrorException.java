package exception;

public class SyntaxErrorException extends Exception {

	public SyntaxErrorException(String msg, Throwable t) {
		super(msg, t);
	}
}
