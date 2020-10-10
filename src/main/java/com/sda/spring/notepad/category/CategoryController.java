package com.sda.spring.notepad.category;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);

        if (category.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(category.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Category save(@RequestBody Category category) {  //zawsze jak jest request body to uzywamy posta, we wszystkich innych geta
        return categoryService.save(category);
    }
}
