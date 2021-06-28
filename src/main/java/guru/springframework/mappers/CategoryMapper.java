package guru.springframework.mappers;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryCommand toCommand(Category source);
    Category fromCommand(CategoryCommand source);
}
