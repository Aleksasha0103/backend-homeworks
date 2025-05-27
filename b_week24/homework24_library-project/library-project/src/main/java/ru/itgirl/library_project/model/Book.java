package ru.itgirl.library_project.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Setter
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    @Setter
    private Genre genre;

    @ManyToMany
    @Setter
    @JoinTable(
            name = "author_book",
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"),
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
    private Set<Author> authors;
}