package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.*;

public class RecipeServiceImplTest extends TestCase {
    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    public void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    public void testGetRecipes() {
        // Prepare what we are mocking, i.e., recipeRepository. Here we mock the findAll() to return mocked data.
        Recipe recipe = new Recipe();
        HashSet<Recipe> mockedRecipes = new HashSet<>();
        mockedRecipes.add(recipe);
        when(recipeRepository.findAll()).thenReturn(mockedRecipes);

        // Focus of the UT is on the service method - Verify expected value and number of calls (logic workflow correctness)
        Set<Recipe> returnedRecipes = recipeService.getRecipes();
        assertEquals(returnedRecipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        // Prepare what we are mocking, i.e., recipeRepository. Here we mock the findAll() to return mocked data.
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        // Focus of the UT is on the service method - Verify expected value and number of calls (logic workflow correctness)
        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull("Null recipe returned", recipeReturned);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }
}
