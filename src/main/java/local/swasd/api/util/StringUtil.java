package local.swasd.api.util;

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
}