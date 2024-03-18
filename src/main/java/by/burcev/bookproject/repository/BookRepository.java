package by.burcev.bookproject.repository;

import by.burcev.bookproject.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);
    @Transactional
    void deleteByTitle(String title);
}
