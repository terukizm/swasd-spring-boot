package local.swasd.api.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

	// とりあえず不要
	// @ExceptionHandler(AbstractException.class)
	// public String exception(AbstractException e) {
	// return "inv:" + e.toString();
	// }
	//
	// @ExceptionHandler(Exception.class)
	// public String exception(Exception e) {
	// logger.error("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
	// logger.error(e.getMessage(), e);
	// return "その他の例外:" + e.toString();
	// }

}
