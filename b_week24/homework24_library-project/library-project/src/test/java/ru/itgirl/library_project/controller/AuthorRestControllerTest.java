package ru.itgirl.library_project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.itgirl.library_project.dto.AuthorDto;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class AuthorRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAuthorById() throws Exception {
        Long authorId = 1L;
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(authorId);
        authorDto.setName("Александр");
        authorDto.setSurname("Пушкин");

        mockMvc.perform(MockMvcRequestBuilders.get("/author/{id}", authorId))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(authorDto.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(authorDto.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value(authorDto.getSurname()));
    }

    @Test
    public void testGetAuthorBySurname() throws Exception {
        Long authorId = 1L;
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(authorId);
        authorDto.setName("Александр");
        authorDto.setSurname("Пушкин");

        mockMvc.perform(MockMvcRequestBuilders.get("/author")
                        .param("surname", "Пушкин"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(authorDto.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(authorDto.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value(authorDto.getSurname()));
    }

    @Test
    public void testGetAuthorBySurnameV2() throws Exception {
        Long authorId = 1L;
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(authorId);
        authorDto.setName("Александр");
        authorDto.setSurname("Пушкин");

        mockMvc.perform(MockMvcRequestBuilders.get("/author/V2")
                        .param("surname", "Пушкин"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(authorDto.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(authorDto.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value(authorDto.getSurname()));
    }

    @Test
    public void testGetAuthorBySurnameV3() throws Exception {
        Long authorId = 1L;
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(authorId);
        authorDto.setName("Александр");
        authorDto.setSurname("Пушкин");

        mockMvc.perform(MockMvcRequestBuilders.get("/author/V3")
                        .param("surname", "Пушкин"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(authorDto.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(authorDto.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value(authorDto.getSurname()));
    }

    @Test
    public void testCreateAuthor() throws Exception {
        AuthorDto sendedAuthorDto = new AuthorDto();
        sendedAuthorDto.setName("John");
        sendedAuthorDto.setSurname("Doe");

        mockMvc.perform(MockMvcRequestBuilders.post("/author/create")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(sendedAuthorDto)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(sendedAuthorDto.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value(sendedAuthorDto.getSurname()));
    }

    @Test
    public void testUpdateAuthor() throws Exception {
        AuthorDto sendedAuthorDto = new AuthorDto();
        sendedAuthorDto.setId(6L);
        sendedAuthorDto.setName("John");
        sendedAuthorDto.setSurname("Doe");

        AuthorDto receivedAuthorDto = new AuthorDto();
        receivedAuthorDto.setId(sendedAuthorDto.getId());
        receivedAuthorDto.setName(sendedAuthorDto.getName());
        receivedAuthorDto.setSurname(sendedAuthorDto.getSurname());

        mockMvc.perform(MockMvcRequestBuilders.put("/author/update")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(receivedAuthorDto)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(sendedAuthorDto.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(sendedAuthorDto.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value(sendedAuthorDto.getSurname()));
    }

    @Test
    public void testDeleteAuthor() throws Exception {
        Long authorId = 6L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/author/delete/{id}", authorId))
                .andExpect(status().isOk());
    }
}