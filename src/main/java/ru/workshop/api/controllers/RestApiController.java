package ru.workshop.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.workshop.api.models.Book;
import ru.workshop.api.repositories.BooksRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class RestApiController {
    private final BooksRepository booksRepository;

    public RestApiController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;

        booksRepository.saveAll(List.of(
                new Book("Dune", "Frank Herbert"),
                new Book("The Lord of the Rings", "J. R. R. Tolkien"),
                new Book("The Hobbit", "J. R. R. Tolkien")
        ));
    }

    @GetMapping
    Iterable<Book> getBooks() {
        return booksRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Book> getBookById(@PathVariable String id) {
        return booksRepository.findById(id);
    }

    @PostMapping
    Book postBook(@RequestBody Book book) {
        return booksRepository.save(book);
    }

    @PutMapping("/{id}")
    ResponseEntity<Book> putBook(@PathVariable String id, @RequestBody Book book) {
        return (!booksRepository.existsById(id)) ? new ResponseEntity<>(booksRepository.save(book), HttpStatus.CREATED) : new ResponseEntity<>(booksRepository.save(book), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable String id) {
        booksRepository.deleteById(id);
    }
}
