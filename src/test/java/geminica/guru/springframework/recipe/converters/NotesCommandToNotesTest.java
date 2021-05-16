package geminica.guru.springframework.recipe.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import geminica.guru.springframework.recipe.commands.NotesCommand;
import geminica.guru.springframework.recipe.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotesCommandToNotesTest {
  private NotesCommandToNotes objectUnderTest;

  @BeforeEach
  void setUp() {
    objectUnderTest = new NotesCommandToNotes();
  }

  @Test
  void testNullSource() {
    assertNull(objectUnderTest.convert(null));
  }

  @Test
  void testEmptySource() {
    assertNotNull(objectUnderTest.convert(new NotesCommand()));
  }

  @Test
  void testConversion() {
    // given
    long expectedId = 1;
    String expectedNotes = "some";
    NotesCommand source = new NotesCommand(expectedId, expectedNotes);

    // when
    Notes result = objectUnderTest.convert(source);

    // then
    assertNotNull(result);
    assertEquals(expectedId, result.getId());
    assertEquals(expectedNotes, result.getNotes());
  }
}
