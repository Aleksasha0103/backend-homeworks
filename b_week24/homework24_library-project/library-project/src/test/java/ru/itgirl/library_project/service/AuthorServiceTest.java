package ru.itgirl.library_project.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import ru.itgirl.library_project.dto.AuthorCreateDto;
import ru.itgirl.library_project.dto.AuthorDto;
import ru.itgirl.library_project.dto.AuthorUpdateDto;
import ru.itgirl.library_project.model.Author;
import ru.itgirl.library_project.model.Book;
import ru.itgirl.library_project.repository.AuthorRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@SpringBootTest
public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorServiceImpl authorService;

    @Test
    public void testGetAuthorById() {
        Long id = 1L;
        String name = "John";
        String surname = "Doe";
        Set<Book> books = new HashSet<>();
        Author author = new Author(id, name, surname, books);

        when(authorRepository.findById(id)).thenReturn(Optional.of(author));

        AuthorDto authorDto = authorService.getAuthorById(id);

        verify(authorRepository).findById(id);
        Assertions.assertEquals(authorDto.getId(), author.getId());
        Assertions.assertEquals(authorDto.getName(), author.getName());
        Assertions.assertEquals(authorDto.getSurname(), author.getSurname());
    }

    @Test
    public void testGetAuthorByIdNotFound() {
        Long id = 1L;

        when(authorRepository.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(NoSuchElementException.class, () -> authorService.getAuthorById(id));
        verify(authorRepository).findById(id);
    }


    @Test
    public void testGetAuthorBySurnameV1() {
        Long id = 1L;
        String name = "John";
        String surname = "Doe";
        Set<Book> books = new HashSet<>();
        Author author = new Author(id, name, surname, books);

        when(authorRepository.findAuthorBySurname(surname)).thenReturn(Optional.of(author));

        AuthorDto authorDto = authorService.getAuthorBySurnameV1(surname);

        verify(authorRepository).findAuthorBySurname(surname);
        Assertions.assertEquals(authorDto.getId(), author.getId());
        Assertions.assertEquals(authorDto.getName(), author.getName());
        Assertions.assertEquals(authorDto.getSurname(), author.getSurname());
    }

    @Test
    public void testGetAuthorBySurnameV1NotFound() {
        String surname = "Doe";

        when(authorRepository.findAuthorBySurname(surname)).thenReturn(Optional.empty());

        Assertions.assertThrows(NoSuchElementException.class, () -> authorService.getAuthorBySurnameV1(surname));
        verify(authorRepository).findAuthorBySurname(surname);
    }

    @Test
    public void testGetAuthorBySurnameV2() {
        Long id = 1L;
        String name = "John";
        String surname = "Doe";
        Set<Book> books = new HashSet<>();
        Author author = new Author(id, name, surname, books);

        when(authorRepository.findAuthorBySurnameBySql(surname)).thenReturn(Optional.of(author));

        AuthorDto authorDto = authorService.getAuthorBySurnameV2(surname);

        verify(authorRepository).findAuthorBySurnameBySql(surname);
        Assertions.assertEquals(authorDto.getId(), author.getId());
        Assertions.assertEquals(authorDto.getName(), author.getName());
        Assertions.assertEquals(authorDto.getSurname(), author.getSurname());
    }

    @Test
    public void testGetAuthorBySurnameV2NotFound() {
        String surname = "Doe";

        when(authorRepository.findAuthorBySurnameBySql(surname)).thenReturn(Optional.empty());

        Assertions.assertThrows(NoSuchElementException.class, () -> authorService.getAuthorBySurnameV2(surname));
        verify(authorRepository).findAuthorBySurnameBySql(surname);
    }

    @Test
    public void testGetAuthorBySurnameV3() {
        Long id = 1L;
        String name = "John";
        String surname = "Doe";
        Set<Book> books = new HashSet<>();
        Author author = new Author(id, name, surname, books);

        when(authorRepository.findOne(any(Specification.class))).thenReturn(Optional.of(author));

        AuthorDto authorDto = authorService.getAuthorBySurnameV3(surname);

        verify(authorRepository).findOne(any(Specification.class));
        Assertions.assertEquals(authorDto.getId(), author.getId());
        Assertions.assertEquals(authorDto.getName(), author.getName());
        Assertions.assertEquals(authorDto.getSurname(), author.getSurname());
    }

    @Test
    public void testGetAuthorBySurnameV3NotFound() {
        String surname = "Doe";

        when(authorRepository.findOne(any(Specification.class))).thenReturn(Optional.empty());

        Assertions.assertThrows(NoSuchElementException.class, () -> authorService.getAuthorBySurnameV3(surname));
        verify(authorRepository).findOne(any(Specification.class));
    }

    @Test
    public void testCreateAuthor() {
        Long id = 1L;
        String name = "John";
        String surname = "Doe";
        Set<Book> books = new HashSet<>();
        AuthorCreateDto authorCreateDto = new AuthorCreateDto(name, surname);
        Author author = new Author(id, name, surname, books);

        when(authorRepository.save(any(Author.class))).thenReturn(author);

        AuthorDto authorDto = authorService.createAuthor(authorCreateDto);

        verify(authorRepository).save(any(Author.class));
        Assertions.assertEquals(authorDto.getId(), author.getId());
        Assertions.assertEquals(authorDto.getName(), author.getName());
        Assertions.assertEquals(authorDto.getSurname(), author.getSurname());
    }

    @Test
    public void testCreateAuthorFailed() {
        String name = "John";
        String surname = "Doe";
        AuthorCreateDto authorCreateDto = new AuthorCreateDto(name, surname);

        when(authorRepository.save(any(Author.class))).thenThrow(new RuntimeException("Error occurred during creating author"));

        Assertions.assertThrows(RuntimeException.class, () -> authorService.createAuthor(authorCreateDto));
        verify(authorRepository).save(any(Author.class));
    }

    @Test
    public void testUpdateAuthor() {
        Long id = 1L;
        String name = "John";
        String surname = "Doe";
        AuthorUpdateDto authorUpdateDto = new AuthorUpdateDto(id, name, surname);
        Author existingAuthor = new Author(id, "existingName", "existingSurname", new HashSet<>());
        Author updatedAuthor = new Author(id, name, surname, new HashSet<>());

        when(authorRepository.findById(id)).thenReturn(Optional.of(existingAuthor));
        when(authorRepository.save(any(Author.class))).thenReturn(updatedAuthor);

        AuthorDto authorDto = authorService.updateAuthor(authorUpdateDto);

        verify(authorRepository).save(any(Author.class));
        Assertions.assertEquals(id, authorDto.getId());
        Assertions.assertEquals(name, authorDto.getName());
        Assertions.assertEquals(surname, authorDto.getSurname());
    }

    @Test
    public void testUpdateAuthorFailed() {
        Long id = 1L;
        String name = "John";
        String surname = "Doe";
        AuthorUpdateDto authorUpdateDto = new AuthorUpdateDto(id, name, surname);

        when(authorRepository.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(NoSuchElementException.class, () -> authorService.updateAuthor(authorUpdateDto));
        verify(authorRepository).findById(id);
    }


    @Test
    public void testDeleteAuthor() {
        Long id = 1L;
        String name = "John";
        String surname = "Doe";
        Set<Book> books = new HashSet<>();

        Author existingAuthor = new Author(id, name, surname, books);

        when(authorRepository.findById(id)).thenReturn(Optional.of(existingAuthor));
        authorService.deleteAuthor(id);

        verify(authorRepository).deleteById(id);
    }

    @Test
    public void testDeleteAuthorFailed() {
        Long id = 1L;

        when(authorRepository.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(NoSuchElementException.class, () -> authorService.deleteAuthor(id));
        verify(authorRepository).findById(id);
    }

    @Test
    public void testGetAllAuthors() {
        List<Author> authors = new ArrayList<>();
        Author author = Author.builder()
                .id(1L)
                .name("John")
                .surname("Doe")
                .build();

        authors.add(author);

        when(authorRepository.findAll()).thenReturn(authors);

        List<AuthorDto> authorDtos = authorService.getAllAuthors();

        verify(authorRepository).findAll();

        Assertions.assertEquals(1, authorDtos.size());
        Assertions.assertEquals(author.getId(), authorDtos.get(0).getId());
        Assertions.assertEquals(author.getName(), authorDtos.get(0).getName());
        Assertions.assertEquals(author.getSurname(), authorDtos.get(0).getSurname());
    }

    @Test
    public void testGetAllAuthorsNotFound() {
        when(authorRepository.findAll()).thenReturn(List.of());

        List<AuthorDto> authorDtos = authorService.getAllAuthors();

        assertNotNull(authorDtos);
        assertTrue(authorDtos.isEmpty());
    }
}