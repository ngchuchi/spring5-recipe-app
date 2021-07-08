package guru.springframework.mappers;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.domain.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IngredientMapper {
    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);

    IngredientCommand toCommand(Ingredient source);
    Ingredient fromCommand(IngredientCommand source);
}
