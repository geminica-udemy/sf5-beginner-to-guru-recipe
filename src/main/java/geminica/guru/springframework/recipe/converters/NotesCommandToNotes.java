package geminica.guru.springframework.recipe.converters;

import geminica.guru.springframework.recipe.commands.NotesCommand;
import geminica.guru.springframework.recipe.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {
  @Nullable
  @Override
  public Notes convert(NotesCommand source) {
    if (source == null) {
      return null;
    }

    Notes notes = new Notes();
    notes.setId(source.getId());
    notes.setNotes(source.getNotes());
    return notes;
  }
}
