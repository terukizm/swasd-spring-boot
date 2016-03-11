package local.swasd.api.validator;

import org.springframework.stereotype.Component;

import local.swasd.api.exception.InvalidParameterException;

@Component
public class CommonParameterValidator {

	/**
	 * validate "limit" parameter
	 *
	 * @param limit
	 * @return
	 * @throws InvalidParameterException
	 */
	public void validateLimit(int limit) throws InvalidParameterException {
		if (limit < 0) {
			throw new InvalidParameterException("limitに負の値を指定することはできません。");
		}
	}

	/**
	 * validate "offset" parameter
	 *
	 * @param offset
	 * @return
	 * @throws InvalidParameterException
	 */
	public void validateOffset(int offset) throws InvalidParameterException {
		if (offset < 0) {
			throw new InvalidParameterException("offsetに負の値を指定することはできません。");
		}
	}

	/**
	 * validate "limit" and "offset" parameter
	 *
	 * @param limit
	 * @param offset
	 * @return
	 * @throws InvalidParameterException
	 */
	public void validateLimitAndOffset(Integer limit, Integer offset) throws InvalidParameterException {
		validateLimit(limit);
		validateOffset(offset);
		if (limit == 0 && offset != 0) {
			throw new InvalidParameterException("offsetに値を指定する場合、limitの値は必須です。");
		}
	}
}
