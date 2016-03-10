package local.swasd.api.repository.stub;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import local.swasd.api.entity.Todo;

@Repository
public class TodoStubRepository {

	private List<Todo> todoList;

	public TodoStubRepository() {
		this.todoList = __stub();
	}

	public List<Todo> list() {
		return todoList;
	}

	public Todo get(int id) {
		for (Todo todo : todoList) {
			if (todo.getId() == id) {
				return todo;
			}
		}

		return null;
	}

	// スタブ用データ作成

	private List<Todo> __stub() {
		List<Todo> list = new ArrayList<Todo>();
		for (int i = 1; i <= 10; i++) {
			Todo todo = new Todo();
			todo.setId(i);
			todo.setTitle("タイトル" + i);
			todo.setDone((i % 2) == 0);
			list.add(todo);
		}
		return list;
	}

}