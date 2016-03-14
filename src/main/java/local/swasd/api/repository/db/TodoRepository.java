package local.swasd.api.repository.db;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import local.swasd.api.entity.Todo;

public interface TodoRepository extends PagingAndSortingRepository<Todo, Long>, JpaSpecificationExecutor<Todo> {
}