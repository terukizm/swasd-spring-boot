package local.swasd.api.configuration.error;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.web.context.request.RequestAttributes;

/**
 * @see http://qiita.com/tksmaru/items/8b387196ad312f913a2a
 */
public class DevelopErrorAttributes extends DefaultErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
		Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);

		// StackTraceを追加
		Throwable error = getError(requestAttributes);
		addStackTrace(errorAttributes, error);
		return errorAttributes;
	}

	private void addStackTrace(Map<String, Object> errorAttributes, Throwable error) {
		StringWriter stackTrace = new StringWriter();
		error.printStackTrace(new PrintWriter(stackTrace));
		stackTrace.flush();
		String text = stackTrace.toString().replace("\t", "    ");
		errorAttributes.put("trace", text.split("\n"));
	}

}