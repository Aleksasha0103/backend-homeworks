package ru.itgirl.library_project.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.itgirl.library_project.dto.AuthorDto;
import ru.itgirl.library_project.dto.BookCreateDto;
import ru.itgirl.library_project.dto.BookDto;
import ru.itgirl.library_project.dto.BookUpdateDto;
import ru.itgirl.library_project.model.Author;
import ru.itgirl.library_project.model.Book;
import ru.itgirl.library_project.model.Genre;
import ru.itgirl.library_project.repository.AuthorRepository;
import ru.itgirl.library_project.repository.BookRepository;
import ru.itgirl.library_project.repository.GenreRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final AuthorRepository authorRepository;
    private Optional<Object> books;

    @Override
    public BookDto getByNameV1(String name) {
        log.info("Try to find book by name {}", name);
        Book book = bookRepository.findBookByName(name)
                .orElseThrow(() -> {
                    log.error("Book with name {} not found", name);
                    return new NoSuchElementException("No value present");
                });
        log.info("Book with name {} found", name);
        return convertEntityToDto(book);
    }

    @Override
    public BookDto getByNameV2(String name) {
        log.info("Try to find book by name {}", name);
        Book book = bookRepository.findBookByNameBySql(name)
                .orElseThrow(() -> {
                    log.error("Book with name {} not found", name);
                    return new NoSuchElementException("No value present");
                });
        log.info("Book with name {} found", name);
        return convertEntityToDto(book);
    }

    @Override
    public BookDto getByNameV3(String name) {
        log.info("Try to find book by name {}", name);
        Specification<Book> specification = Specification.where(new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                return cb.equal(root.get("name"), name);
            }
        });
        Book book = bookRepository.findOne(specification)
                .orElseThrow(() -> {
                    log.error("Book with name {} not found", name);
                    return new NoSuchElementException("No value present");
                });
        log.info("Book with name {} found", name);
        return convertEntityToDto(book);
    }

    @Override
    public BookDto createBook(BookCreateDto bookCreateDto) {
        log.info("Try to create book {}", bookCreateDto.getName());
        try {
            Book book = convertDtoToEntity(bookCreateDto);
            book = bookRepository.save(book);
            BookDto bookDto = convertEntityToDto(book);
            log.info("Book created successfully with id: {}", bookDto.getId());
            return bookDto;
        } catch (Exception e) {
            log.error("Error occurred during creating book {}", bookCreateDto.getName());
            throw e;
        }
    }

    private Book convertDtoToEntity(BookCreateDto bookCreateDto) {
        Genre genre = genreRepository.findByName(bookCreateDto.getGenre().getName())
                .orElseGet(() -> {
                    Genre newGenre = new Genre();
                    newGenre.setName(bookCreateDto.getGenre().getName());
                    return genreRepository.save(newGenre);
                });

        Set<Author> authors = bookCreateDto.getAuthors().stream()
                .map(authorDto -> {
                    Author author = new Author();
                    author.setName(authorDto.getName());
                    author.setSurname(authorDto.getSurname());
                    return author;
                })
                .collect(Collectors.toSet());

        authors = new HashSet<>(authorRepository.saveAll(authors));

        return Book.builder()
                .name(bookCreateDto.getName())
                .genre(genre)
                .authors(authors)
                .build();
    }

    private BookDto convertEntityToDto(Book book) {
        List<AuthorDto> authorDtoList = null;
        if (book.getAuthors() != null) {
            authorDtoList = book.getAuthors()
                    .stream()
                    .map(author -> AuthorDto.builder()
                            .name(author.getName())
                            .surname(author.getSurname())
                            .build())
                    .toList();
        }

        BookDto bookDto = BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .genre(book.getGenre().getName())
                .authors(authorDtoList)
                .build();
        return bookDto;
    }

    @Override
    public BookDto updateBook(BookUpdateDto bookUpdateDto) {
        log.info("Try to update book with id {}", bookUpdateDto.getId());
        try {
            if (bookUpdateDto.getId() == null) {
                throw new IllegalArgumentException("Id книги не может быть null.");
            }

            Book book = bookRepository.findById(bookUpdateDto.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Книга с данным id отсутствует в базе данных."));
            book.setName(bookUpdateDto.getName());

            Genre genre = genreRepository.findByName(bookUpdateDto.getGenre().getName())
                    .orElseGet(() -> {
                        Genre newGenre = new Genre();
                        newGenre.setName(bookUpdateDto.getGenre().getName());
                        return genreRepository.save(newGenre);
                    });
            book.setGenre(genre);

            Set<Author> authors = new HashSet<>();
            for (AuthorDto authorDto : bookUpdateDto.getAuthors()) {
                Author author = authorRepository.findById(authorDto.getId())
                        .orElseGet(() -> {
                            Author newAuthor = new Author();
                            newAuthor.setName(authorDto.getName());
                            newAuthor.setSurname(authorDto.getSurname());
                            return authorRepository.save(newAuthor);
                        });
                author.setName(authorDto.getName());
                author.setSurname(authorDto.getSurname());
                authors.add(author);
            }
            book.setAuthors(authors);
            Book savedBook = bookRepository.save(book);
            BookDto bookDto = convertEntityToDto(savedBook);
            log.info("Book with id {} updated successfully", bookDto.getId());
            return bookDto;
        } catch (Exception e) {
            log.error("Error occurred during updating book with id {}", bookUpdateDto.getId(), e);
            throw e;
        }
    }

    @Override
    public void deleteBook(Long id) {
        log.info("Try to delete book with id {}", id);
        try {
            bookRepository.deleteById(id);
            log.info("Book with id {} deleted successfully", id);
        } catch (Exception e) {
            log.error("Error occurred during deleting book with id {}", id);
            throw e;
        }
    }

    @Override
    public List<BookDto> getAllBooks() {
        log.info("Try to find list of books");
        try {
            List<Book> books = bookRepository.findAll();
            log.info("List of books found successfully");
            return books.stream().map(this::convertEntityToDto).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error occurred during searching list of books", e);
            throw e;
        }
    }
}