package ru.itgirl.library_project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirl.library_project.dto.AuthorDto;
import ru.itgirl.library_project.service.AuthorService;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/author/{id}")
    AuthorDto getAuthorById(@PathVariable("id") Long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/author")
    AuthorDto getAuthorBySurname(@RequestParam("surname") String surname) {
        return authorService.getAuthorBySurnameV1(surname);
    }

    @GetMapping("/author/V2")
    AuthorDto getAuthorBySurnameV2(@RequestParam("surname") String surname) {
        return authorService.getAuthorBySurnameV2(surname);
    }

    @GetMapping("/author/V3")
    AuthorDto getAuthorBySurnameV3(@RequestParam("surname") String surname) {
        return authorService.getAuthorBySurnameV3(surname);
    }
}