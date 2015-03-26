package project.warehouse_manager.exceptions;

public class UnitDoesNotExistException extends Exception {
	public UnitDoesNotExistException() {
		super();
	}
	
	public UnitDoesNotExistException(String message) {
		super(message);
	}
	
	public UnitDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UnitDoesNotExistException(Throwable cause) {
		super(cause);
	}
}
