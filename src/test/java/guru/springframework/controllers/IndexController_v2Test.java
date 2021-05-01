package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import junit.framework.TestCase;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class IndexController_v2Test extends TestCase {
    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController indexController;

    public void setUp() {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    public void testIndex() {
        // Verify correct view name is returned and interaction with service method and add-attribute method are correct.
        String viewName = indexController.index(model);

        assertEquals("recipes/index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
    }
}
