package local.swasd.api.exception;

public class WebAPIException extends Exception {

	public WebAPIException(Exception e) {
		super(e);
	}

	private static final long serialVersionUID = 1L;

	private Integer status;
	private String type;
	private String description;

}
