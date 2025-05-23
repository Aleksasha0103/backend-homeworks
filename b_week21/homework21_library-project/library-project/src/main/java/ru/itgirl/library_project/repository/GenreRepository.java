package ru.itgirl.library_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itgirl.library_project.model.Genre;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Optional<Genre> findByName(String name);
}