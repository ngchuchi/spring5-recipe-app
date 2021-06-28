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
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {
    private NotesMapper mapper = NotesMapper.INSTANCE;

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand source) {
        return mapper.fromCommand(source);
    }
}
