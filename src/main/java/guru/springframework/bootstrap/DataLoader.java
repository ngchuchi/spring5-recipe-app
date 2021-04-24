package guru.springframework.bootstrap;


import guru.springframework.domain.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
@EnableCaching
public class DataLoader implements ApplicationRunner {
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Category americanCategory = categoryRepository.findByDescription("American").orElseThrow(IllegalArgumentException::new);
        Category mexicanCategory = categoryRepository.findByDescription("Mexican").orElseThrow(IllegalArgumentException::new);

        Recipe guacamole = new Recipe();
        guacamole.setDescription("Guacamole");
        guacamole.setPrepTime(10);
        guacamole.setCookTime(10);
        guacamole.setServings(4);
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamole.setDirections("Guacamole Direction...");

        // Set Notes.
        String notesStr = "Guacamole Notes...";
        setNotes(guacamole, notesStr);

        // Set Categories.
        setCategories(guacamole, americanCategory, mexicanCategory);

        // Set Ingredients
        String[] ingredientStrings = new String[]{
                "2;Each;ripe avocados",
                "0.25;Teaspoon;of salt, more to taste",
                "1;Tablespoon;fresh lime juice or lemon juice",
                "2;Tablespoon;to 1/4 cup of minced red onion or thinly sliced green onion",
                "1;Each;serrano chiles, stems and seeds removed, minced",
                "2;Tablespoon;cilantro (leaves and tender stems), finely chopped",
                "1;Dash;freshly grated black pepper",
                "0.5;Each;ripe tomato, seeds and pulp removed, chopped"
        };
        setIngredients(guacamole, ingredientStrings);

        // Save to repository.
        recipeRepository.save(guacamole);
        System.out.println("Saved Recipe: guacamole");

        Recipe chickenTaco = new Recipe();
        chickenTaco.setDescription("Chicken Tacos");
        chickenTaco.setPrepTime(20);
        chickenTaco.setCookTime(15);
        chickenTaco.setServings(6);
        chickenTaco.setDifficulty(Difficulty.MODERATE);
        chickenTaco.setSource("");
        chickenTaco.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        chickenTaco.setDirections("Chicken Taco Direction...");

        // Set Notes.
        notesStr = "Chicken Taco Notes...";
        setNotes(chickenTaco, notesStr);

        // Set Categories.
        setCategories(guacamole, americanCategory, mexicanCategory);

        // Set Ingredients
        ingredientStrings = new String[]{
                "2;Tablespoon;ancho chili powder",
                "1;Teaspoon;dried oregano",
                "1;Teaspoon;dried cumin",
                "1;Teaspoon;sugar",
                "0.5;Teaspoon;salt",
                "1;Each;clove garlic, finely chopped",
                "1;Tablespoon;finely grated orange zest",
                "3;Tablespoon;fresh-squeezed orange juice",
                "2;Tablespoon;olive oil",
                "4;Each;skinless, boneless chicken thighs (1 1/4 pounds)",
                "8;Each;small corn tortillas",
                "3;Cup;packed baby arugula (3 ounces)",
                "2;Each;medium ripe avocados, sliced",
                "4;Each;radishes, thinly sliced",
                "0.5;Pint;cherry tomatoes, halved",
                "0.25;Each;red onion, thinly sliced",
                "1;Each;Roughly chopped cilantro",
                "0.5;Cup;sour cream thinned with 1/4 cup milk",
                "1;Each;lime, cut into wedges"
        };
        setIngredients(chickenTaco, ingredientStrings);

        recipeRepository.save(chickenTaco);
        System.out.println("Saved Recipe: Chicken Taco");
    }

    private void setNotes(Recipe recipe, String notesStr) {
        Notes notes = new Notes();
        notes.setRecipeNotes(notesStr);
        notes.setRecipe(recipe);
        recipe.setNotes(notes);
    }

    private void setCategories(Recipe recipe, Category... categories) {
        for (Category category: categories) {
            recipe.getCategories().add(category);
//            category.getRecipes().add(recipe);
        }
    }

    private void setIngredients(Recipe recipe, String[] ingredientStrings) {
        for (String ingStr: ingredientStrings) {
            String[] items = ingStr.split(";");
            String qtyStr = items[0];
            String uomStr = items[1];
            String desStr = items[2];

            Ingredient ingredient = new Ingredient();
            ingredient.setAmount(new BigDecimal(qtyStr));
            ingredient.setUnitOfMeasure(findUnitOfMeasure(uomStr));
            ingredient.setDescription(desStr);
            ingredient.setRecipe(recipe);
            recipe.getIngredients().add(ingredient);
        }
    }

    private final Map<String, UnitOfMeasure> unitOfMeasureMap = new HashMap<>();
    private UnitOfMeasure findUnitOfMeasure(String description) {
        return unitOfMeasureMap.computeIfAbsent(description, k -> unitOfMeasureRepository.findByDescription(k).orElseThrow());
    }
}
