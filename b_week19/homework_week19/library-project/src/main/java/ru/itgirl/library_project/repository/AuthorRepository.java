package ru.itgirl.library_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import ru.itgirl.library_project.model.Author;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {
    Optional<Author> findAuthorBySurname(String surname);

    @Query(nativeQuery = true, value = "SELECT * FROM author WHERE surname = ?")
    Optional<Author> findAuthorBySurnameBySql(String surname);
}