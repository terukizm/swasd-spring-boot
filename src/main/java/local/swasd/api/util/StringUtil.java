package local.swasd.api.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	public static boolean isUrl(String text) throws Exception {
		String str = "((https?|ftp)\\:([\\w|\\:\\!\\#\\$\\%\\=\\&\\-\\^\\`\\\\|\\@\\~\\[\\{\\]\\}\\;\\+\\*\\,\\.\\?\\/]+))";
		Pattern patt = Pattern.compile(str, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
		Matcher matcher = patt.matcher(text);
		return matcher.matches();
	}

	public static boolean isNotUrl(String text) throws Exception {
		return !isUrl(text);
	}

	public static String urlEncode(String text) throws UnsupportedEncodingException {
		return urlEncode(text, "UTF-8");
	}

	public static String urlEncode(String text, String charset) throws UnsupportedEncodingException {
		String encoded = URLEncoder.encode(text, charset);
		encoded = encoded.replace("*", "%2a");
		encoded = encoded.replace("-", "%2d");
		return encoded;
	}
}