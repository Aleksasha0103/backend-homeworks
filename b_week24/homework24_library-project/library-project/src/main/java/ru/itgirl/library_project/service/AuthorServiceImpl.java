package ru.itgirl.library_project.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itgirl.library_project.dto.AuthorCreateDto;
import ru.itgirl.library_project.dto.AuthorDto;
import ru.itgirl.library_project.dto.AuthorUpdateDto;
import ru.itgirl.library_project.dto.BookDto;
import ru.itgirl.library_project.model.Author;
import ru.itgirl.library_project.repository.AuthorRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorDto getAuthorById(Long id) {
        log.info("Try to find author by id {}", id);
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()) {
            AuthorDto authorDto = convertEntityToDto(author.get());
            log.info("Author: {}", authorDto.toString());
            return authorDto;
        } else {
            log.error("Author with id {} not found", id);
            throw new NoSuchElementException("No value present");
        }
    }

    private AuthorDto convertToDto(Author author) {
        List<BookDto> bookDtoList = author.getBooks()
                .stream()
                .map(book -> BookDto.builder()
                        .genre(book.getGenre().getName())
                        .name(book.getName())
                        .id(book.getId())
                        .build()
                ).toList();
        return AuthorDto.builder()
                .books(bookDtoList)
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .build();
    }

    @Override
    public AuthorDto getAuthorBySurnameV1(String surname) {
        log.info("Try to find author by surname {}", surname);
        Author author = authorRepository.findAuthorBySurname(surname)
                .orElseThrow(() -> {
                    log.error("Author with surname {} not found", surname);
                    return new NoSuchElementException("No value present");
                });
        log.info("Author with surname {} found", surname);
        return convertToDto(author);
    }


    private AuthorDto convertEntityToDto(Author author) {
        List<BookDto> bookDtoList = null;
        if (author.getBooks() != null) {
            bookDtoList = author.getBooks()
                    .stream()
                    .map(book -> BookDto.builder()
                            .genre(book.getGenre().getName())
                            .name(book.getName())
                            .id(book.getId())
                            .build())
                    .toList();
        }

        AuthorDto authorDto = AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .books(bookDtoList)
                .build();
        return authorDto;
    }

    @Override
    public AuthorDto getAuthorBySurnameV2(String surname) {
        log.info("Try to find author by surname {}", surname);
        Author author = authorRepository.findAuthorBySurnameBySql(surname)
                .orElseThrow(() -> {
                    log.error("Author with surname {} not found", surname);
                    return new NoSuchElementException("No value present");
                });
        log.info("Author with surname {} found", surname);
        return convertEntityToDto(author);
    }


    @Override
    public AuthorDto getAuthorBySurnameV3(String surname) {
        log.info("Try to find author by surname {}", surname);
        Specification<Author> specification = Specification.where(new Specification<Author>() {
            @Override
            public Predicate toPredicate(Root<Author> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                return cb.equal(root.get("surname"), surname);
            }
        });

        Author author = authorRepository.findOne(specification)
                .orElseThrow(() -> {
                    log.error("Author with surname {} not found", surname);
                    return new NoSuchElementException("No value present");
                });
        log.info("Author with surname {} found", surname);
        return convertEntityToDto(author);
    }

    @Override
    public AuthorDto createAuthor(AuthorCreateDto authorCreateDto) {
        log.info("Try to create author {} {}", authorCreateDto.getName(), authorCreateDto.getSurname());
        try {
            Author author = authorRepository.save(convertDtoToEntity(authorCreateDto));
            AuthorDto authorDto = convertEntityToDto(author);
            log.info("Author created successfully with id: {}", authorDto.getId());
            return authorDto;
        } catch (Exception e) {
            log.error("Error occurred during creating author {} {}", authorCreateDto.getName(), authorCreateDto.getSurname());
            throw e;
        }
    }

    private Author convertDtoToEntity(AuthorCreateDto authorCreateDto) {
        return Author.builder()
                .name(authorCreateDto.getName())
                .surname(authorCreateDto.getSurname())
                .build();
    }

    @Override
    public AuthorDto updateAuthor(AuthorUpdateDto authorUpdateDto) {
        log.info("Try to update author with id {}", authorUpdateDto.getId());
        Author author = authorRepository.findById(authorUpdateDto.getId())
                .orElseThrow(() -> {
                    log.error("Author with id {} not found", authorUpdateDto.getId());
                    return new NoSuchElementException("No value present");
                });

        author.setName(authorUpdateDto.getName());
        author.setSurname(authorUpdateDto.getSurname());
        Author savedAuthor = authorRepository.save(author);
        AuthorDto authorDto = convertEntityToDto(savedAuthor);
        log.info("Author with id {} updated successfully", authorDto.getId());
        return authorDto;
    }

    @Override
    public void deleteAuthor(Long id) {
        log.info("Try to delete author with id {}", id);
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Author with id " + id + " not found"));
        try {
            authorRepository.deleteById(id);
            log.info("Author with id {} deleted successfully", id);
        } catch (Exception e) {
            log.error("Error occurred during deleting author with id {}", id);
            throw e;
        }
    }


    @Override
    public List<AuthorDto> getAllAuthors() {
        log.info("Try to find list of authors");
        try {
            List<Author> authors = authorRepository.findAll();
            log.info("List of authors found successfully");
            return authors.stream().map(this::convertEntityToDto).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error occurred during searching list of authors", e);
            throw e;
        }
    }
}