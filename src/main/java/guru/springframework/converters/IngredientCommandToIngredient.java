package guru.springframework.converters;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.domain.Ingredient;
import guru.springframework.mappers.IngredientMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {
    private IngredientMapper mapper = IngredientMapper.INSTANCE;

    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        return mapper.fromCommand(source);
    }
}
