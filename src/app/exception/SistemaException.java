package app.exception;

public class SistemaException extends Exception {

	public SistemaException(Object value) {
		super(value.toString());
	}
}