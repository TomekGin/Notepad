package com.sda.spring.notepad.note;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody
@RestController //zastepuje dwa powyzsze
@RequiredArgsConstructor
//@RequestMapping("/api")   //wtedy mozna skasowac dodatkowo 'api'z linkow nizej
public class NoteController {

    //api/notes(/{id})
    private final NoteService noteService;

    @PostMapping("/api/note")
    public void save(@RequestBody Note note) {  //RequetBody - mowi ze w ciele zapytania powinien przyjsc obiekt
        noteService.save(note);
    }

    @DeleteMapping("/api/note/{id}")
    public void deleteById(@PathVariable Long id) {
        noteService.deleteById(id);
    }

    @GetMapping("/api/note/{id}")
//    public Note getById(@PathVariable("id") Long veryStrangeIdName) {
    public ResponseEntity<Note> getById(@PathVariable Long id) {    //PathVariable wstawi id z  klamer z gory do funkcji tutaj
        Note note = null;
        try {
            note = noteService.getById(id);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.I_AM_A_TEAPOT)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(note);
    }

    @GetMapping("/api/note")
    public ResponseEntity<List<Note>> getAll() {
        List<Note> all = noteService.getAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(all);
    }

    @GetMapping("/api/note/find")
    public List<Note> getByTitleAndContent(
            @RequestParam("title") String title,
            @RequestParam("content") String content) {
        return noteService.getByTitleAndContent(title, content);
    }

}