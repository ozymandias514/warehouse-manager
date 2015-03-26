package project.warehouse_manager.exceptions;

public class UnitAlreadyOwnedException extends Exception {
	public UnitAlreadyOwnedException() {
		super();
	}
	
	public UnitAlreadyOwnedException(String message) {
		super(message);
	}
	
	public UnitAlreadyOwnedException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UnitAlreadyOwnedException(Throwable cause) {
		super(cause);
	}
	
}
