package local.swasd.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import local.swasd.api.entity.Todo;
import local.swasd.api.request.TodoRequest;
import local.swasd.api.response.TodoResponse;
import local.swasd.api.service.TodoService;
import local.swasd.api.validator.CommonParameterValidator;

@RestController
@RequestMapping(value = "/todos")
public class TodoController extends AbstractController {

	@Autowired
	CommonParameterValidator commonParameterValidator;

	@Autowired
	TodoService todoService;

	/**
	 * GET /todos (direct-use entity)
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Todo> list(@RequestParam(value = "limit", required = false, defaultValue = "0") Integer limit,
			@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
			@RequestParam(value = "done_only", required = false, defaultValue = "false") Boolean doneOnly)
			throws Exception {

		// parameter check
		commonParameterValidator.validateLimitAndOffset(limit, offset);

		List<Todo> result = todoService.list(limit, offset, doneOnly);
		return result;
	}

	/**
	 * GET /todos/{id}
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public TodoResponse get(@PathVariable long id) throws Exception {
		TodoResponse result = todoService.get(id);
		return result;
	}

	/**
	 * POST /todos?title=xxxxx (POST 'application/x-www-form-urlencoded' sample)
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
	@ResponseStatus(HttpStatus.CREATED)
	public String post(@RequestParam(value = "title", required = true) String title) throws Exception {
		todoService.post(title);
		return "ok";
	}

	/**
	 * PUT /todos/{id} (PUT 'application/json' and RequestBody input sample)
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public String put(@PathVariable long id, @RequestBody TodoRequest input) throws Exception {
		todoService.put(id, input);
		return "ok";
	}

	/**
	 * DELETE /todos/{id}
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String delete(@PathVariable long id) throws Exception {
		todoService.delete(id);
		return "ok";
	}
}