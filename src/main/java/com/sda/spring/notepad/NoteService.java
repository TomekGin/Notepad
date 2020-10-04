package com.sda.spring.notepad;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class NoteService {

    private final SpringNoteRepository noteRepository;

    private final Censore censore;

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }

    public void save(Note note) {
        Note censoredNote = censore.censore(note);
        noteRepository.save(censoredNote);

//        Optional<Note> fetchedNote = noteRepository.findById(1L);
////        fetchedNote.ifPresent(note1 -> log.info(note.toString()));
//        if (fetchedNote.isPresent()){
//            Note noteFromDb = fetchedNote.get();
//            log.info(noteFromDb.toString());
//        }
    }

    public Note getById(Long id) {
        Optional<Note> byId = noteRepository.findById(id);
        if (byId.isEmpty()) {
            throw new RuntimeException("Note is required");
        }
        return byId.get();
    }

    public List<Note> getAll() {
        List<Note> array = new ArrayList<>();
        noteRepository.findAll().forEach(array::add);
        return array;
    }

    public List<Note> getByTitleAndContent(String title, String content) {
        return noteRepository.findByTitleAndContent(title, content);
    }

}
