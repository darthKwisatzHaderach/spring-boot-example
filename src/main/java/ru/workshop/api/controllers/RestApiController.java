package ru.workshop.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.workshop.api.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class RestApiController {
    private List<Book> books = new ArrayList<>();

    public RestApiController() {
        books.addAll(List.of(
                new Book("Dune", "Frank Herbert"),
                new Book("The Lord of the Rings", "J. R. R. Tolkien"),
                new Book("The Hobbit", "J. R. R. Tolkien")
        ));
    }

    @GetMapping
    Iterable<Book> getBooks() {
        return books;
    }

    @GetMapping("/{id}")
    Optional<Book> getBookById(@PathVariable String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                return Optional.of(b);
            }
        }

        return Optional.empty();
    }

    @PostMapping
    Book postBook(@RequestBody Book book) {
        books.add(book);

        return book;
    }

    @PutMapping("/{id}")
    ResponseEntity<Book> putBook(@PathVariable String id, @RequestBody Book book) {
        int bookIndex = -1;

        for (Book b : books) {
            if (b.getId().equals(id)) {
                bookIndex = books.indexOf(b);
                books.set(bookIndex, book);
            }
        }

        return (bookIndex == -1) ? new ResponseEntity<>(postBook(book), HttpStatus.CREATED) : new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable String id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
