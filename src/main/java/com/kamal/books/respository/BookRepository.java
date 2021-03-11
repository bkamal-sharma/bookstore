package com.kamal.books.respository;

import com.kamal.books.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface BookRepository extends JpaRepository<Book, Long> {
}
