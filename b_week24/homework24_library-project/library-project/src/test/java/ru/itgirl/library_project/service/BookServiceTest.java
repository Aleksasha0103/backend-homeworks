package ru.itgirl.library_project.service;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import ru.itgirl.library_project.dto.*;
import ru.itgirl.library_project.model.Author;
import ru.itgirl.library_project.model.Book;
import ru.itgirl.library_project.model.Genre;
import ru.itgirl.library_project.repository.AuthorRepository;
import ru.itgirl.library_project.repository.BookRepository;
import ru.itgirl.library_project.repository.GenreRepository;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private GenreRepository genreRepository;

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    public void testGetByNameV1() {
        Long id = 1L;
        String name = "BookExample";

        Author author = new Author(1L, "John", "Doe", null);
        Set<Author> authors = new HashSet<>();
        authors.add(author);

        Genre genre = new Genre(1L, "GenreName", null);

        Book book = new Book(id, name, genre, authors);

        when(bookRepository.findBookByName(name)).thenReturn(Optional.of(book));

        BookDto bookDto = bookService.getByNameV1(name);

        verify(bookRepository).findBookByName(name);
        Assertions.assertEquals(id, bookDto.getId());
        Assertions.assertEquals(name, bookDto.getName());
        Assertions.assertNotNull(bookDto.getAuthors());
        Assertions.assertFalse(bookDto.getAuthors().isEmpty());

        AuthorDto authorDto = (AuthorDto) bookDto.getAuthors().toArray()[0];
        Assertions.assertEquals("John", authorDto.getName());
        Assertions.assertEquals("Doe", authorDto.getSurname());
    }

    @Test
    public void testGetByNameV1NotFound() {
        String name = "BookExample";

        when(bookRepository.findBookByName(name)).thenReturn(Optional.empty());

        Assertions.assertThrows(NoSuchElementException.class, () -> bookService.getByNameV1(name));
        verify(bookRepository).findBookByName(name);
    }


    @Test
    public void testGetByNameV2() {
        Long id = 1L;
        String name = "BookExample";

        Author author = new Author(1L, "John", "Doe", null);
        Set<Author> authors = new HashSet<>();
        authors.add(author);

        Genre genre = new Genre(1L, "GenreName", null);

        Book book = new Book(id, name, genre, authors);

        when(bookRepository.findBookByNameBySql(name)).thenReturn(Optional.of(book));

        BookDto bookDto = bookService.getByNameV2(name);

        verify(bookRepository).findBookByNameBySql(name);
        Assertions.assertEquals(id, bookDto.getId());
        Assertions.assertEquals(name, bookDto.getName());
        Assertions.assertNotNull(bookDto.getAuthors());
        Assertions.assertFalse(bookDto.getAuthors().isEmpty());

        AuthorDto authorDto = bookDto.getAuthors().get(0);
        Assertions.assertEquals("John", authorDto.getName());
        Assertions.assertEquals("Doe", authorDto.getSurname());
    }

    @Test
    public void testGetByNameV2NotFound() {
        String name = "BookExample";

        when(bookRepository.findBookByNameBySql(name)).thenReturn(Optional.empty());

        Assertions.assertThrows(NoSuchElementException.class, () -> bookService.getByNameV2(name));
        verify(bookRepository).findBookByNameBySql(name);
    }

    @Test
    public void testGetBookByNameV3() {
        Long id = 1L;
        String name = "BookExample";

        Author author = new Author(1L, "John", "Doe", null);
        Set<Author> authors = new HashSet<>();
        authors.add(author);

        Genre genre = new Genre(1L, "GenreName", null);

        Book book = new Book(id, name, genre, authors);

        when(bookRepository.findOne(any(Specification.class))).thenReturn(Optional.of(book));

        BookDto bookDto = bookService.getByNameV3(name);

        verify(bookRepository).findOne(any(Specification.class));
        Assertions.assertEquals(id, bookDto.getId());
        Assertions.assertEquals(name, bookDto.getName());
        Assertions.assertNotNull(bookDto.getAuthors());
        Assertions.assertFalse(bookDto.getAuthors().isEmpty());

        AuthorDto authorDto = bookDto.getAuthors().get(0);
        Assertions.assertEquals("John", authorDto.getName());
        Assertions.assertEquals("Doe", authorDto.getSurname());
    }

    @Test
    public void testGetByNameV3NotFound() {
        String name = "BookExample";

        when(bookRepository.findOne(any(Specification.class))).thenReturn(Optional.empty());

        Assertions.assertThrows(NoSuchElementException.class, () -> bookService.getByNameV3(name));
        verify(bookRepository).findOne(any(Specification.class));
    }

    @Test
    public void testCreateBook() {
        String name = "BookExample";
        String genreName = "GenreName";

        GenreDto genreDto = new GenreDto();
        genreDto.setName(genreName);

        BookCreateDto bookCreateDto = new BookCreateDto();
        bookCreateDto.setName(name);
        bookCreateDto.setGenre(genreDto);
        bookCreateDto.setAuthors(new HashSet<>());

        Genre genre = new Genre();
        genre.setName(genreName);

        Book savedBook = new Book(1L, name, genre, new HashSet<>());

        when(bookRepository.save(any(Book.class))).thenReturn(savedBook);

        BookDto bookDto = bookService.createBook(bookCreateDto);

        verify(bookRepository).save(any(Book.class));
        Assertions.assertEquals(savedBook.getId(), bookDto.getId());
        Assertions.assertEquals(savedBook.getName(), bookDto.getName());
    }

    @Test
    public void testCreateBookFailed() {
        String name = "BookExample";
        String genreName = "GenreName";

        GenreDto genreDto = new GenreDto();
        genreDto.setName(genreName);

        BookCreateDto bookCreateDto = new BookCreateDto();
        bookCreateDto.setName(name);
        bookCreateDto.setGenre(genreDto);
        bookCreateDto.setAuthors(new HashSet<>());

        Genre genre = new Genre();
        genre.setName(genreName);

        when(bookRepository.save(any(Book.class))).thenThrow(new RuntimeException("Error occurred during creating book"));

        Assertions.assertThrows(RuntimeException.class, () -> bookService.createBook(bookCreateDto));
        verify(bookRepository).save(any(Book.class));
    }

    @Test
    public void testUpdateBook() {
        Long id = 1L;
        String name = "BookExample";
        String genreName = "GenreName";

        AuthorDto existingAuthorDto = new AuthorDto();
        existingAuthorDto.setId(1L);
        existingAuthorDto.setName("ExistingAuthorName");
        existingAuthorDto.setSurname("ExistingAuthorSurname");

        AuthorDto updatedAuthorDto = new AuthorDto();
        updatedAuthorDto.setName("UpdatedAuthorName");
        updatedAuthorDto.setSurname("UpdatedAuthorSurname");

        List<AuthorDto> authorDtos = Arrays.asList(existingAuthorDto, updatedAuthorDto);

        GenreDto genreDto = new GenreDto();
        genreDto.setName(genreName);

        BookUpdateDto bookUpdateDto = new BookUpdateDto();
        bookUpdateDto.setId(id);
        bookUpdateDto.setName(name);
        bookUpdateDto.setGenre(genreDto);
        bookUpdateDto.setAuthors(authorDtos);

        Genre existingGenre = new Genre();
        existingGenre.setName("ExistingGenre");

        Book existingBook = new Book(id, "ExistingBook", existingGenre, new HashSet<>());

        Genre updatedGenre = new Genre();
        updatedGenre.setName(genreName);

        Author existingAuthor = new Author(1L, "ExistingAuthorName", "ExistingAuthorSurname", null);
        Author updatedAuthor = new Author(2L, "UpdatedAuthorName", "UpdatedAuthorSurname", null);
        Set<Author> updatedAuthorsList = new HashSet<>(Arrays.asList(existingAuthor, updatedAuthor));

        Book updatedBook = new Book(id, name, updatedGenre, updatedAuthorsList);

        when(bookRepository.findById(id)).thenReturn(Optional.of(existingBook));
        when(authorRepository.findById(1L)).thenReturn(Optional.of(existingAuthor));
        when(authorRepository.save(any(Author.class))).thenReturn(updatedAuthor);
        when(genreRepository.findByName(genreName)).thenReturn(Optional.of(updatedGenre));
        when(bookRepository.save(any(Book.class))).thenReturn(updatedBook);

        BookDto bookDto = bookService.updateBook(bookUpdateDto);

        verify(bookRepository).save(any(Book.class));
        verify(authorRepository).findById(1L);

        Assertions.assertEquals(id, bookDto.getId());
        Assertions.assertEquals(name, bookDto.getName());
        Assertions.assertEquals(genreName, bookDto.getGenre());
        Assertions.assertEquals(2, bookDto.getAuthors().size());

        boolean foundExistingAuthor = false;
        boolean foundUpdatedAuthor = false;

        for (AuthorDto authorDto : bookDto.getAuthors()) {
            if ("ExistingAuthorName".equals(authorDto.getName())) {
                foundExistingAuthor = true;
            }
            if ("UpdatedAuthorName".equals(authorDto.getName())) {
                foundUpdatedAuthor = true;
            }
        }

        Assertions.assertTrue(foundExistingAuthor);
        Assertions.assertTrue(foundUpdatedAuthor);
    }

    @Test
    public void testUpdateBookFailed() {
        Long id = 1L;
        String name = "BookExample";
        String genreName = "GenreName";

        AuthorDto existingAuthorDto = new AuthorDto();
        existingAuthorDto.setId(1L);
        existingAuthorDto.setName("ExistingAuthorName");
        existingAuthorDto.setSurname("ExistingAuthorSurname");

        AuthorDto updatedAuthorDto = new AuthorDto();
        updatedAuthorDto.setName("UpdatedAuthorName");
        updatedAuthorDto.setSurname("UpdatedAuthorSurname");

        List<AuthorDto> authorDtos = Arrays.asList(existingAuthorDto, updatedAuthorDto);

        GenreDto genreDto = new GenreDto();
        genreDto.setName(genreName);

        BookUpdateDto bookUpdateDto = new BookUpdateDto();
        bookUpdateDto.setId(id);
        bookUpdateDto.setName(name);
        bookUpdateDto.setGenre(genreDto);
        bookUpdateDto.setAuthors(authorDtos);

        Genre existingGenre = new Genre();
        existingGenre.setName("ExistingGenre");

        Book existingBook = new Book(id, "ExistingBook", existingGenre, new HashSet<>());

        Genre updatedGenre = new Genre();
        updatedGenre.setName(genreName);

        Author existingAuthor = new Author(1L, "ExistingAuthorName", "ExistingAuthorSurname", null);
        Author updatedAuthor = new Author(2L, "UpdatedAuthorName", "UpdatedAuthorSurname", null);
        Set<Author> updatedAuthorsList = new HashSet<>(Arrays.asList(existingAuthor, updatedAuthor));

        Book updatedBook = new Book(id, name, updatedGenre, updatedAuthorsList);

        when(bookRepository.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(EntityNotFoundException.class, () -> bookService.updateBook(bookUpdateDto));
        verify(bookRepository).findById(id);
    }

    @Test
    public void testDeleteBook() {
        Long id = 1L;
        String name = "BookExample";
        String genreName = "GenreName";

        Genre genre = new Genre();
        genre.setName(genreName);

        Book savedBook = new Book(1L, name, genre, new HashSet<>());

        when(bookRepository.findById(id)).thenReturn(Optional.of(savedBook));
        bookService.deleteBook(id);

        verify(bookRepository).findById(id);
        verify(bookRepository).deleteById(id);
    }

    @Test
    public void testDeleteBookFailed() {
        Long id = 1L;

        when(bookRepository.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(EntityNotFoundException.class, () -> bookService.deleteBook(id));
        verify(bookRepository).findById(id);
    }

    @Test
    public void testGetAllBooks() {
        Long id = 1L;
        String name = "BookExample";
        String genreName = "GenreName";

        Genre genre = new Genre(1L, genreName, null);
        Author author = new Author(1L, "John", "Doe", new HashSet<>());

        Set<Author> authors = new HashSet<>();
        authors.add(author);

        Book book = new Book(id, name, genre, authors);
        List<Book> books = new ArrayList<>();
        books.add(book);

        when(bookRepository.findAll()).thenReturn(books);

        List<BookDto> bookDtos = bookService.getAllBooks();

        verify(bookRepository).findAll();
        Assertions.assertEquals(1, bookDtos.size());

        BookDto resultDto = bookDtos.get(0);
        Assertions.assertEquals(book.getId(), bookDtos.get(0).getId());
        Assertions.assertEquals(book.getName(), bookDtos.get(0).getName());
        Assertions.assertEquals(book.getGenre().getName(), bookDtos.get(0).getGenre());

        Assertions.assertNotNull(bookDtos.get(0).getAuthors());
        Assertions.assertEquals(1, bookDtos.get(0).getAuthors().size());

        AuthorDto[] authorDtos = bookDtos.get(0).getAuthors().toArray(new AuthorDto[0]);
        AuthorDto authorDto = authorDtos[0];

        Assertions.assertEquals("John", authorDto.getName());
        Assertions.assertEquals("Doe", authorDto.getSurname());

    }

    @Test
    public void testgetAllBooksFailed() {
        String name = "BookExample";
        String genreName = "GenreName";

        GenreDto genreDto = new GenreDto();
        genreDto.setName(genreName);

        BookCreateDto bookCreateDto = new BookCreateDto();
        bookCreateDto.setName(name);
        bookCreateDto.setGenre(genreDto);
        bookCreateDto.setAuthors(new HashSet<>());

        Genre genre = new Genre();
        genre.setName(genreName);

        when(bookRepository.save(any(Book.class))).thenThrow(new RuntimeException("Error occurred during creating book"));

        Assertions.assertThrows(RuntimeException.class, () -> bookService.createBook(bookCreateDto));
        verify(bookRepository).save(any(Book.class));
    }
}