package spring.boot;

import org.springframework.data.repository.CrudRepository;

public interface StateRepo extends CrudRepository<State, Integer> {
}
