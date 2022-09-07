package ru.workshop.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.workshop.api.models.Book;

public interface BooksRepository extends MongoRepository<Book, String> {
}
