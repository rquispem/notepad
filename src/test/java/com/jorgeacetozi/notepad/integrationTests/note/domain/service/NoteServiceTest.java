package com.jorgeacetozi.notepad.integrationTests.note.domain.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.jorgeacetozi.notepad.note.domain.model.Note;
import com.jorgeacetozi.notepad.note.domain.service.NoteService;

@SpringBootTest
@ActiveProfiles("test")
public class NoteServiceTest {
	
	@Autowired
	private NoteService noteService;
	
	private Note note;
	
	@BeforeEach
	public void setUp() {
		note = new Note("Kubernetes", "Best container orchestration tool ever");
	}
	
	@AfterEach
	public void destroy() {
		noteService.delete(note);
	}
	
	@Test
	public void shouldCreateNoteWithTitleAndContent() {
		Note createdNote = noteService.create(note);
		assertThat(createdNote.getId(), notNullValue());
		assertThat(createdNote.getWordCount(), is(5));
	}
}
