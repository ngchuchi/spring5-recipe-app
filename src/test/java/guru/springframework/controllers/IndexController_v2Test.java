package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import junit.framework.TestCase;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

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
        // Given
        Set<Recipe> recipes = new HashSet<>();
        Recipe r1 = new Recipe(); r1.setId(1L); recipes.add(r1);
        Recipe r2 = new Recipe(); r2.setId(2L); recipes.add(r2);
        when(recipeService.getRecipes()).thenReturn(recipes);

        // When
        String viewName = indexController.index(model);

        // Then
        // Verify correct view name is returned and interaction with service method and add-attribute method are correct.
        assertEquals("recipes/index", viewName);
        verify(recipeService, times(1)).getRecipes();

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }
}
