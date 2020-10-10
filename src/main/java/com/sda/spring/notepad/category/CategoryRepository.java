package com.sda.spring.notepad.category;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    //HQL
    //@Query("from Category c where c.color = 'red'")
    //SQL
    @Query(value = "SELECT * FROM CATEGORY", nativeQuery = true)
    public List<Category> findAllRedCategories();
}
