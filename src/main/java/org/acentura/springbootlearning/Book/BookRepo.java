package org.acentura.springbootlearning.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
    boolean existsByTitle(String title);
}
