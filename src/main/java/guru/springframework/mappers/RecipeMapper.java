package guru.springframework.mappers;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipeMapper {
    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    RecipeCommand toCommand(Recipe source);
    Recipe fromCommand(RecipeCommand source);
}
