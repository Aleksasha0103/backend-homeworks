package ru.itgirl.library_project.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.itgirl.library_project.dto.AuthorDto;
import ru.itgirl.library_project.dto.BookDto;
import ru.itgirl.library_project.dto.GenreDto;
import ru.itgirl.library_project.model.Genre;
import ru.itgirl.library_project.repository.GenreRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public GenreDto getGenreById(Long id) {
        log.info("Try to find genre by id {}", id);
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Genre with id {} not found", id);
                    return new NoSuchElementException("No value present");
                });
        log.info("Genre with id {} found", id);
        return convertToDto(genre);
    }

    private GenreDto convertToDto(Genre genre) {
        List<BookDto> bookDtoList = genre.getBooks()
                .stream()
                .map(book -> {
                    List<AuthorDto> authorDtoList = book.getAuthors().stream()
                            .map(author -> AuthorDto.builder()
                                    .id(author.getId())
                                    .name(author.getName())
                                    .surname(author.getSurname())
                                    .build()
                            ).toList();

                    return BookDto.builder()
                            .id(book.getId())
                            .name(book.getName())
                            .authors(authorDtoList)
                            .build();
                })
                .toList();

        return GenreDto.builder()
                .id(genre.getId())
                .name(genre.getName())
                .books(bookDtoList)
                .build();
    }
}