package com.sda.spring.notepad;

import com.sda.spring.notepad.category.Category;
import com.sda.spring.notepad.category.CategoryService;
import com.sda.spring.notepad.note.Note;
import com.sda.spring.notepad.note.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;

@Slf4j
@Component
@RequiredArgsConstructor
public class Invoker implements CommandLineRunner {

//    private final NoteRepository noteRepository;    // wymagane dlatego moge uzyc requiredArgCoinstructor
//    private final Censore censore;
//    usuwam i tworze jednego noteService'a

    private final NoteService noteService;
    private final CategoryService categoryService;

    @Override
    public void run(String... args) throws Exception {

        Note note = saveNewNote("first title");
        Note note2 = saveNewNote("second title");
        Category category = saveNewCategory();
        note.setCategory(category);
        note2.setCategory(category);

//        category.setNotes(Collections.singleton(note));
        categoryService.save(category);
        noteService.save(note);
        noteService.save(note2);
    }

    private Category saveNewCategory() {
        Category category = new Category();
        category.setName("Animals");
        category.setColor("red");
        return category;
    }

    private Note saveNewNote(String title) {
        Note note = new Note();
        note.setTitle(title);
        note.setContent("Lorem ipsum... twoja stara, wypierdzielaj");
        note.setCreationDate(LocalDateTime.now());
        note.setLastUpdateDate(LocalDateTime.now());
        return note;
    }
}
