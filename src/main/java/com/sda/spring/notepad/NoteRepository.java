package com.sda.spring.notepad;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NoteRepository {
    private Note note = null;

    public void save(Note note){
        this.note = note;
    }

    public Optional<Note> getById(Long id) {
        return Optional.of(note);
    }

    public void deleteById(Note note) {
        note = null;
    }

}
