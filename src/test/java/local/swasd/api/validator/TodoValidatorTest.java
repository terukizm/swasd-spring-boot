package local.swasd.api.validator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import local.swasd.api.Application;
import local.swasd.api.exception.InvalidParameterException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TodoValidatorTest {

	@Autowired
	TodoValidator todoValidator;

	@Test
	public void isExistsBadWord_禁止文字列なし() throws Exception {
		try {
			String title = "テスト用文字列";
			todoValidator.isExistsBadWord(title);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void isExistsBadWord_禁止文字列を含む() throws Exception {
		try {
			String title = "テスト用0xdeadbeaf文字列";
			todoValidator.isExistsBadWord(title);
			Assert.fail();
		} catch (InvalidParameterException e) {
			// OK
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
