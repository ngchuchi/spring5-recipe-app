package guru.springframework.repositories;

import guru.springframework.domain.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.assertFalse;


@RunWith(SpringRunner.class)
@DataJpaTest
public class RecipeRepositoryIT {
    @Autowired
    private RecipeRepository recipeRepository;

    @Before
    public void setUp() {
        Recipe recipe = new Recipe();
        recipeRepository.save(recipe);
    }

    @Test
    public void findAll() {
        Set<Recipe> recipeSet = recipeRepository.findAll();
        assertFalse(recipeSet.isEmpty());
    }
}
