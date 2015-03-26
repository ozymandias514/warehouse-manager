package project.warehouse_manager.exceptions;

public class UnitNotOwnedException extends Exception {
	public UnitNotOwnedException() {
		super();
	}
	
	public UnitNotOwnedException(String message) {
		super(message);
	}
	
	public UnitNotOwnedException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UnitNotOwnedException(Throwable cause) {
		super(cause);
	}
}
