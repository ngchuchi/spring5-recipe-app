package guru.springframework.repositories;

import guru.springframework.domain.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryIT {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findByDescription() {
        Optional<Category> category = categoryRepository.findByDescription("Italian");
        assertEquals("Italian", category.orElse(new Category()).getDescription());
    }
}
