package com.sda.spring.notepad;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class NoteService {

    private final NoteRepository noteRepository;

    private final Censore censore;

    public void save(Note note) {
        Note censoredNote = censore.censore(note);
        noteRepository.save(censoredNote);

        Optional<Note> fetchedNote = noteRepository.getById(1L);
//        fetchedNote.ifPresent(note1 -> log.info(note.toString()));
        if (fetchedNote.isPresent()){
            Note noteFromDb = fetchedNote.get();
            log.info(noteFromDb.toString());
        }
    }

    public Note getById(Long id) {
        Optional<Note> byId = noteRepository.getById(id);
        if (!byId.isPresent()) {
            throw new RuntimeException("Note is required");
        }
        return byId.get();
    }
}
