package project.warehouse_manager.exceptions;

public class CustomerAlreadyExistsException extends Exception {
	public CustomerAlreadyExistsException() {
		super();
	}
	
	public CustomerAlreadyExistsException(String message) {
		super(message);
	}
	
	public CustomerAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CustomerAlreadyExistsException(Throwable cause) {
		super(cause);
	}

}
