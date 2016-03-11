package local.swasd.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidParameterException extends AbstractException {

	private static final long serialVersionUID = 1L;

	public InvalidParameterException(String message) {
		super(message);
	}

}
