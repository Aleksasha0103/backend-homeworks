package ru.itgirl.library_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookUpdateDto {
    private Long id;
    @Size(min = 2)
    @NotBlank(message = "Необходимо указать название книги")
    private String name;
    @NotNull(message = "Необходимо указать жанр")
    private GenreDto genre;
    @NotEmpty(message = "Необходимо указать автора (-ов)")
    private List<AuthorDto> authors;
}