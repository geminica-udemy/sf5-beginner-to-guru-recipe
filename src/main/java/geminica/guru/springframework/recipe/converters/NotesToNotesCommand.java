package geminica.guru.springframework.recipe.converters;

import geminica.guru.springframework.recipe.commands.NotesCommand;
import geminica.guru.springframework.recipe.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {
  @Nullable
  @Override
  public NotesCommand convert(Notes source) {
    if (source == null) {
      return null;
    }

    return new NotesCommand(source.getId(), source.getNotes());
  }
}
