package guru.springframework.converters;

import guru.springframework.commands.NotesCommand;
import guru.springframework.domain.Notes;
import guru.springframework.mappers.NotesMapper;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand>{
    private NotesMapper mapper = NotesMapper.INSTANCE;

    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes source) {
        return mapper.toCommand(source);
    }
}
