package guru.springframework.converters;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.domain.Ingredient;
import guru.springframework.mappers.IngredientMapper;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {
    private IngredientMapper mapper = IngredientMapper.INSTANCE;

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        return mapper.toCommand(source);
    }
}
