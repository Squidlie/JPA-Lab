package spring.boot;

import org.springframework.data.repository.CrudRepository;

public interface GameRepo extends CrudRepository<Game, Integer> {
}
