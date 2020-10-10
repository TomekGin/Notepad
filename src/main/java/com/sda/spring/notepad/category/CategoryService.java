package com.sda.spring.notepad.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<Category> findById(Long id){
        log.info("searching for category with id:{}", id);
        return categoryRepository.findById(id);
    }

    public Category save(Category category) {
        log.info("saving new category");
        return categoryRepository.save(category);
    }
}
