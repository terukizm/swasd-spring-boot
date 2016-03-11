package local.swasd.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import local.swasd.api.exception.AbstractException;

@ControllerAdvice
public class ExceptionControllerAdvice {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

	@ExceptionHandler(AbstractException.class)
	public String exception(AbstractException e) {
		return "inv:" + e.toString();
	}

	@ExceptionHandler(Exception.class)
	public String exception(Exception e) {
		logger.error("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		logger.error(e.getMessage(), e);
		return "その他の例外:" + e.toString();
	}

}
