package local.swasd.api.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import local.swasd.api.exception.InvalidParameterException;

@Component
public class TodoValidator {
	private String[] badWords = { "bad", "悪い", "0xdeadbeaf" };

	// 業務バリデーションのサンプル
	public void isExistsBadWord(String title) throws InvalidParameterException {
		if (StringUtils.isEmpty(title)) {
			return;
		}
		for (String badWord : badWords) {
			if (title.contains(badWord)) {
				throw new InvalidParameterException("titleに 「" + badWord + "」 という文字列を入力することはできません。");
			}
		}
	}

}