package ru.itgirl.library_project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.itgirl.library_project.dto.*;

import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class BookRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetBookByName() throws Exception {
        Long bookId = 1L;
        BookDto bookDto = new BookDto();
        bookDto.setId(bookId);
        bookDto.setName("Война и мир");

        mockMvc.perform(MockMvcRequestBuilders.get("/book")
                        .param("name", "Война и мир"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(bookDto.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(bookDto.getName()));
    }

    @Test
    public void testGetBookByNameV2() throws Exception {
        Long bookId = 1L;
        BookDto bookDto = new BookDto();
        bookDto.setId(bookId);
        bookDto.setName("Война и мир");

        mockMvc.perform(MockMvcRequestBuilders.get("/book/v2")
                        .param("name", "Война и мир"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(bookDto.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(bookDto.getName()));
    }

    @Test
    public void testGetBookByNameV3() throws Exception {
        Long bookId = 1L;
        BookDto bookDto = new BookDto();
        bookDto.setId(bookId);
        bookDto.setName("Война и мир");

        mockMvc.perform(MockMvcRequestBuilders.get("/book/v3")
                        .param("name", "Война и мир"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(bookDto.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(bookDto.getName()));
    }

    @Test
    public void testCreateBook() throws Exception {
        GenreDto genreDto = new GenreDto();
        genreDto.setName("Тестовый жанр");

        AuthorDto authorDto1 = new AuthorDto();
        authorDto1.setName("Тестовое имя автора 1");
        authorDto1.setSurname("Тестовая фамилия автора 1");

        AuthorDto authorDto2 = new AuthorDto();
        authorDto2.setName("Тестовое имя автора 2");
        authorDto2.setSurname("Тестовая фамилия автора 2");

        BookCreateDto bookCreateDto = new BookCreateDto();
        bookCreateDto.setName("Тестовое название книги");
        bookCreateDto.setGenre(genreDto);
        bookCreateDto.setAuthors(Set.of(authorDto1, authorDto2));

        mockMvc.perform(MockMvcRequestBuilders.post("/book/create")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(bookCreateDto)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(bookCreateDto.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.genre").value(genreDto.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.authors").isArray());
    }

    @Test
    public void testUpdateBook() throws Exception {
        GenreDto genreDto = new GenreDto();
        genreDto.setId(5L);
        genreDto.setName("Роман");

        AuthorDto authorDto1 = new AuthorDto();
        authorDto1.setId(7L);
        authorDto1.setName("Марк");
        authorDto1.setSurname("Твен");

        BookUpdateDto bookUpdateDto = new BookUpdateDto();
        bookUpdateDto.setId(5L);
        bookUpdateDto.setName("Таинственный незнакомец");
        bookUpdateDto.setGenre(genreDto);
        bookUpdateDto.setAuthors(List.of(authorDto1));

        mockMvc.perform(MockMvcRequestBuilders.put("/book/update")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(bookUpdateDto)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(bookUpdateDto.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(bookUpdateDto.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.genre").value(genreDto.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.authors").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.authors[0].name").value(authorDto1.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.authors[0].surname").value(authorDto1.getSurname()));
    }

    @Test
    public void testDeleteBook() throws Exception {
        Long bookId = 4L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/book/delete/{id}", bookId))
                .andExpect(status().isOk());
    }
}