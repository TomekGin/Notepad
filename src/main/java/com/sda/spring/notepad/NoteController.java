package com.sda.spring.notepad;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

//    @RequestMapping(value = "/asdasd", method = RequestMethod.GET)
    @GetMapping("/api/note/getall")
    public Note getAll() {
        return noteService.getById(1L);
    }
}
//http://localhost:8080/api/note/getall