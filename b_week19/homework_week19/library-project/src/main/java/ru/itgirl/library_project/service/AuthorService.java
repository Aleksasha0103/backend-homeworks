package ru.itgirl.library_project.service;

import ru.itgirl.library_project.dto.AuthorDto;
import ru.itgirl.library_project.model.Author;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);
    AuthorDto getAuthorBySurnameV1(String surname);
    AuthorDto getAuthorBySurnameV2(String surname);
    AuthorDto getAuthorBySurnameV3(String surname);
}