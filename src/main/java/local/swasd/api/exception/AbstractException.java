package local.swasd.api.exception;

public class AbstractException extends Exception {

	private static final long serialVersionUID = 1L;

	// if need...
	// /** Inner error code **/
	// private Integer code;
	//
	// /** error detail (for logging) **/
	// private String description;

	public AbstractException() {
		super();
	}

	public AbstractException(Exception e) {
		super(e);
	}

	public AbstractException(String message) {
		super(message);
	}

}
