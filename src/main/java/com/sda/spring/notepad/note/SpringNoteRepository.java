package com.sda.spring.notepad.note;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringNoteRepository extends CrudRepository<Note, Long> {
    List<Note> findByTitleAndContent(String title, String content);
}
