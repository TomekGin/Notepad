package com.sda.spring.notepad;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
@Slf4j
@Component
@RequiredArgsConstructor
public class Invoker implements CommandLineRunner {

//    private final NoteRepository noteRepository;    // wymagane dlatego moge uzyc requiredArgCoinstructor
//    private final Censore censore;
//    usuwam i tworze jednego noteService'a

    private final NoteService noteService;

    @Override
    public void run(String... args) throws Exception {
        Note note = new Note();
        note.setId(1L);
        note.setTitle("Sample Note");
        note.setContent("Lorem ipsum... twoja stara, wypierdzielaj");
        note.setCreationDate(LocalDateTime.now());
        note.setLastUpdateDate(LocalDateTime.now());
        noteService.save(note);
    }
}
