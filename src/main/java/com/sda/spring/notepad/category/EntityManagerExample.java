package com.sda.spring.notepad.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

@Component
@RequiredArgsConstructor
public class EntityManagerExample {
    private final EntityManager entityManager;

    public void sample() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        //cb.createQuery()
        //...
    }
}
