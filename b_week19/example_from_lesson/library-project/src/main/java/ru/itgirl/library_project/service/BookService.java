package ru.itgirl.library_project.service;

import ru.itgirl.library_project.dto.BookDto;
import ru.itgirl.library_project.model.Book;

public interface BookService {
    BookDto getByNameV1(String name);
    BookDto getByNameV2(String name);
    BookDto getByNameV3(String name);
}

