package local.swasd.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import local.swasd.api.entity.Todo;
import local.swasd.api.exception.InvalidParameterException;
import local.swasd.api.exception.NotFoundException;
import local.swasd.api.repository.db.TodoRepository;
import local.swasd.api.request.TodoRequest;
import local.swasd.api.response.TodoResponse;
import local.swasd.api.specification.TodoSpecifications;
import local.swasd.api.validator.TodoValidator;

@Service
public class TodoService {

	@Autowired
	TodoRepository todoRepository;

	@Autowired
	TodoValidator todoValidator;

	public List<Todo> list(Integer limit, Integer offset, boolean doneOnly) {
		// where query
		Specifications<Todo> spec = Specifications.where(TodoSpecifications.doneOnly(doneOnly));

		if (limit != 0) {
			Iterable<Todo> result = todoRepository.findAll(spec, new PageRequest(offset, limit));
			return (List<Todo>) Lists.newArrayList(result);
		}

		Iterable<Todo> result = todoRepository.findAll(spec);
		return (List<Todo>) Lists.newArrayList(result);
	}

	public TodoResponse get(long id) throws NotFoundException {
		Todo entity = todoRepository.findOne(id);
		if (entity == null) {
			// TODO: use resource-file (ex. i18n)
			String message = "id=" + id + " is not found.";
			throw new NotFoundException(message);
		}

		TodoResponse response = new TodoResponse();
		BeanUtils.copyProperties(entity, response);

		return response;
	}

	public void post(String title) throws InvalidParameterException {
		todoValidator.isExistsBadWord(title);

		Todo entity = new Todo();
		entity.setTitle(title);
		todoRepository.save(entity);
	}

	public void put(long id, TodoRequest input) throws InvalidParameterException, NotFoundException {
		get(id);
		todoValidator.isExistsBadWord(input.getTitle());

		Todo entity = new Todo();
		entity.setId(id);
		BeanUtils.copyProperties(input, entity);
		todoRepository.save(entity);
	}

	public void delete(long id) throws NotFoundException {
		get(id);
		todoRepository.delete(id);
	}

}