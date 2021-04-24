package guru.springframework.bootstrap;

import org.junit.Test;

public class DataLoaderTest {
    @Test
    public void testLoadIngredients() {
        final String[] ingredientStrings = new String[]{
                "2;;ripe avocados",
                "0.25;teaspoon; of salt, more to taste",
                "1;tablespoon; fresh lime juice or lemon juice",
                "2;tablespoons; to 1/4 cup of minced red onion or thinly sliced green onion",
                ";;1-2 serrano chiles, stems and seeds removed, minced",
                "2;tablespoons; cilantro (leaves and tender stems), finely chopped",
                ";;A dash of freshly grated black pepper",
                "0.5;;ripe tomato, seeds and pulp removed, chopped",
                ";;Red radishes or jicama, to garnish",
                ";;Tortilla chips, to serve"
        };

        for (String ingStr: ingredientStrings) {
            String[] items = ingStr.split(";");
            System.out.println("Qty: " + items[0]);
            System.out.println("Uom: " + items[1]);
            System.out.println("Des: " + items[2]);
        }

    }
}
