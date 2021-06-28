package guru.springframework.converters;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.mappers.RecipeMapper;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand>{
    private RecipeMapper mapper = RecipeMapper.INSTANCE;

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        return mapper.toCommand(source);
    }
}
