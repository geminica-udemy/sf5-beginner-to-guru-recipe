package geminica.guru.springframework.recipe.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import geminica.guru.springframework.recipe.commands.NotesCommand;
import geminica.guru.springframework.recipe.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotesToNotesCommandTest {
  private NotesToNotesCommand objectUnderTest;

  @BeforeEach
  void setUp() {
    objectUnderTest = new NotesToNotesCommand();
  }

  @Test
  void testNullSource() {
    assertNull(objectUnderTest.convert(null));
  }

  @Test
  void testEmptySource() {
    assertNotNull(objectUnderTest.convert(new Notes()));
  }

  @Test
  void testConversion() {
    // given
    long expectedId = 1;
    String expectedNotes = "notes";
    Notes source = new Notes();
    source.setId(expectedId);
    source.setNotes(expectedNotes);

    // when
    NotesCommand result = objectUnderTest.convert(source);

    // then
    assertNotNull(result);
    assertEquals(expectedId, result.getId());
    assertEquals(expectedNotes, result.getNotes());
  }
}
