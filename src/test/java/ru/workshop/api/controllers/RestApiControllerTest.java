package ru.workshop.api.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import ru.workshop.api.models.Book;

@WebFluxTest({RestApiController.class})
class RestApiControllerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBooks(@Autowired WebTestClient client) {
        /*
        Iterable<Book> books = client.get()
                .uri("/books")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Book.class)
                .returnResult()
                .getResponseBody();

        assert books.iterator().hasNext();
        */
    }

    @Test
    void getBookById() {
    }

    @Test
    void postBook() {
    }

    @Test
    void putBook() {
    }

    @Test
    void deleteBook() {
    }
}