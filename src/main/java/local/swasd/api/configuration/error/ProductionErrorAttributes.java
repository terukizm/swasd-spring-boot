package local.swasd.api.configuration.error;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestAttributes;

/**
 * @see http://qiita.com/tksmaru/items/8b387196ad312f913a2a
 */
public class ProductionErrorAttributes extends DefaultErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
		Map<String, Object> errorAttributes = new LinkedHashMap<String, Object>();
		errorAttributes.put("timestamp", new Date());
		addStatus(errorAttributes, requestAttributes);
		// addErrorDetails(errorAttributes, requestAttributes,
		// includeStackTrace);
		// addPath(errorAttributes, requestAttributes);
		return errorAttributes;
	}

	private void addStatus(Map<String, Object> errorAttributes, RequestAttributes requestAttributes) {
		Integer status = getAttribute(requestAttributes, "javax.servlet.error.status_code");
		if (status == null) {
			errorAttributes.put("status", 999);
			errorAttributes.put("error", "None");
			return;
		}
		errorAttributes.put("status", status);
		try {
			errorAttributes.put("error", HttpStatus.valueOf(status).getReasonPhrase());
		} catch (Exception ex) {
			// Unable to obtain a reason
			errorAttributes.put("error", "Http Status " + status);
		}
	}

	@SuppressWarnings("unchecked")
	private <T> T getAttribute(RequestAttributes requestAttributes, String name) {
		return (T) requestAttributes.getAttribute(name, RequestAttributes.SCOPE_REQUEST);
	}
}