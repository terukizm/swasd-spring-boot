package local.swasd.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import local.swasd.api.entity.Todo;
import local.swasd.api.repository.db.TodoRepository;

@Service
public class TodoService {

	// @Autowired
	// TodoStubRepository todoRepository;

	@Autowired
	TodoRepository todoRepository;

	private static final Logger logger = LoggerFactory.getLogger(TodoService.class);

	public Todo get(long id) {
		Todo result = todoRepository.findOne(id);
		return result;
	}

	public List<Todo> list(Integer limit, Integer offset, Boolean doneOnly) {
		Iterable<Todo> result = todoRepository.findAll();
		return (List<Todo>) Lists.newArrayList(result);
	}

}