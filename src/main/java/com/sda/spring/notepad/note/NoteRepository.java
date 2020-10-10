package com.sda.spring.notepad.note;

import java.util.Objects;
import java.util.Optional;

public class NoteRepository {
    private Note note = null;

    public void save(Note note) {
        this.note = note;
    }

    public Optional<Note> getById(Long id) {
        if (note != null && Objects.equals(note.getId(), id)) {
            return Optional.of(note);
        }
        return Optional.empty();
    }

    public void deleteById(Long id) {
        note = null;
    }

}
