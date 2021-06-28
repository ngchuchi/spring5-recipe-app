package guru.springframework.mappers;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.domain.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IngredientMapper {
    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);

    @Mappings({
            @Mapping(target="unitOfMeasure", source="uom")
    })
    IngredientCommand toCommand(Ingredient source);

    @Mappings({
            @Mapping(target="uom", source="unitOfMeasure")
    })
    Ingredient fromCommand(IngredientCommand source);
}
