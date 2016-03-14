package local.swasd.api.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import local.swasd.api.entity.Todo;

public class TodoSpecifications {
	/**
	 * WHERE done = true
	 */
	public static Specification<Todo> doneOnly(boolean doneOnly) {
		return (doneOnly == false) ? null : new Specification<Todo>() {
			@Override
			public Predicate toPredicate(Root<Todo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("done"), true);
			}
		};
	}

}