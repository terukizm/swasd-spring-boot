package local.swasd.api.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import local.swasd.api.entity.Todo;
import local.swasd.api.service.SampleService;
import local.swasd.api.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

	private static final Logger logger = LoggerFactory.getLogger(TodoService.class);

	@Autowired
	TodoService todoService;
	@Autowired
	SampleService sampleService;

	/**
	 * GET /todos
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Todo> list(@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "offset", required = false) Integer offset,
			@RequestParam(value = "done_only", required = false) Boolean doneOnly) throws Exception {
		return todoService.list(limit, offset, doneOnly);
	}

	/**
	 * GET /todos/{id}
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Todo get(@PathVariable long id) throws Exception {
		return todoService.get(id);
	}

	// 動作確認用サンプル

	/**
	 * GET /todos/test
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
	 * GET /todos/dbconnect
	 */
	@RequestMapping(value = "/dbconnect", method = RequestMethod.GET)
	public String dbconnect() {
		return sampleService.isConnectedDB() ? "OK!" : "NG...";
	}
}