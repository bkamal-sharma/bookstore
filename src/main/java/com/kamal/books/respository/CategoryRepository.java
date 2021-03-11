package com.kamal.books.respository;

import com.kamal.books.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "bookCategory", path="book-category")
@CrossOrigin("*")
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
