package com.sda.spring.notepad.note;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sda.spring.notepad.category.Category;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;

    @ManyToOne
    @JsonBackReference
    private Category category;
}
