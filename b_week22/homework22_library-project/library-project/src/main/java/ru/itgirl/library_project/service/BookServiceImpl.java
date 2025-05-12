package ru.itgirl.library_project.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
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

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final AuthorRepository authorRepository;
    private Optional<Object> books;

    @Override
    public BookDto getByNameV1(String name) {
        Book book = bookRepository.findBookByName(name).orElseThrow();
        return convertEntityToDto(book);
    }

    @Override
    public BookDto getByNameV2(String name) {
        Book book = bookRepository.findBookByNameBySql(name).orElseThrow();
        return convertEntityToDto(book);
    }

    @Override
    public BookDto getByNameV3(String name) {
        Specification<Book> specification = Specification.where(new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                return cb.equal(root.get("name"), name);
            }
        });
        Book book = bookRepository.findOne(specification).orElseThrow();
        return convertEntityToDto(book);
    }

    @Override
    public BookDto createBook(BookCreateDto bookCreateDto) {
        Book book = convertDtoToEntity(bookCreateDto);
        book = bookRepository.save(book);
        return convertEntityToDto(book);
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
        return bookDto;
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }
}