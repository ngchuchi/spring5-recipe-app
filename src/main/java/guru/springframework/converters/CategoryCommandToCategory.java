package guru.springframework.converters;


import guru.springframework.commands.CategoryCommand;
import guru.springframework.domain.Category;
import guru.springframework.mappers.CategoryMapper;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category>{
    private CategoryMapper mapper = CategoryMapper.INSTANCE;

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        return mapper.fromCommand(source);
    }
}
