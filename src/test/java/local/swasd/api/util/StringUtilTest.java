package local.swasd.api.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

	@Test
	public void isUrlのテスト_OK_http() throws Exception {
		{
			String url = "http://example.com";
			Assert.assertEquals(true, StringUtil.isUrl(url));
		}
		{
			String url = "http://example.com/test";
			Assert.assertEquals(true, StringUtil.isUrl(url));
		}
		{
			String url = "http://example.com/test?aaaa=eeee";
			Assert.assertEquals(true, StringUtil.isUrl(url));
		}
		{
			String url = "http://example.com/test?title=" + StringUtil.urlEncode("タイトル");
			Assert.assertEquals(true, StringUtil.isUrl(url));
		}
	}

	@Test
	public void isUrlのテスト_OK_その他のプロトコル() throws Exception {
		{
			String url = "https://example.com";
			Assert.assertEquals(true, StringUtil.isUrl(url));
		}
		{
			String url = "ftp://example.com/test";
			Assert.assertEquals(true, StringUtil.isUrl(url));
		}
	}

	@Test
	public void isUrlのテスト_NG() throws Exception {
		{
			String url = "http://日本語.com";
			Assert.assertEquals(false, StringUtil.isUrl(url));
		}
		{
			String url = "ttp://sample.com";
			Assert.assertEquals(false, StringUtil.isUrl(url));
		}
		{
			String url = "http://example.com/test?title=タイトル";
			Assert.assertEquals(false, StringUtil.isUrl(url));
		}
	}

}
