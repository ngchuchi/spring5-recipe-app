package guru.springframework.repositories;

import guru.springframework.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRespository extends CrudRepository<Category, Long> {
}
