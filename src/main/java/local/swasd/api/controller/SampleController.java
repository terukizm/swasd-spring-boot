package local.swasd.api.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import local.swasd.api.service.SampleService;

@RestController
@RequestMapping(value = "/samples")
public class SampleController {

	@Autowired
	SampleService sampleService;

	// 動作確認用サンプル

	/**
	 * GET /samples/test
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public Map<String, Object> test() {
		int[] array = { 1, 2, 3 };
		Map<String, Object> res = new LinkedHashMap<String, Object>();
		res.put("msg", "success");
		res.put("result", array);
		return res;
	}

	/**
	 * GET /samples/dbconnect
	 */
	@RequestMapping(value = "/dbconnect", method = RequestMethod.GET)
	public String dbconnect() {
		sampleService.isConnectedDB();
		return "OK!";
	}

	/**
	 * GET /samples/exception/{status}
	 */
	@RequestMapping(value = "/exception/{status}", method = RequestMethod.GET)
	public String exception(@PathVariable int status) throws Exception {
		throw new Exception("hoge");
	}

}