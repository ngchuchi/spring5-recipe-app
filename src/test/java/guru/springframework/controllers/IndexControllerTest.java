package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import junit.framework.TestCase;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.mockito.Mockito.*;

public class IndexControllerTest extends TestCase {
    IndexController indexController;

    @Mock
    RecipeService recipeService;

    public void setUp() {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    public void testIndex() {
        // Prepare the mocked objects
        Recipe recipe = new Recipe();
        Set<Recipe> mockedRecipes = new HashSet<>();
        mockedRecipes.add(recipe);
        when(recipeService.getRecipes()).thenReturn(mockedRecipes);

        // Verify model contains a recipe list
        Model model = new ExtendedModelMap();
        String viewName = indexController.index(model);

        Map<String, Object> modelMap = model.asMap();
        HashSet<Recipe> returnedRecipes = (HashSet<Recipe>) modelMap.get("recipes");
        assertNotNull(returnedRecipes);
        assertEquals(1, returnedRecipes.size());
        verify(recipeService, times(1)).getRecipes();

        // Verify index method return the correct view name, "recipes/index"
        assertEquals("recipes/index", viewName);
    }
}
