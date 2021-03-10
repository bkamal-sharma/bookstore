package com.kamal.books.respository;

import com.kamal.books.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "bookCategory", path="book-category")
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
