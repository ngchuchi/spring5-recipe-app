package guru.springframework.mappers;

import guru.springframework.commands.NotesCommand;
import guru.springframework.domain.Notes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotesMapper {
    NotesMapper INSTANCE = Mappers.getMapper(NotesMapper.class);

    NotesCommand toCommand(Notes source);
    Notes fromCommand(NotesCommand source);
}
