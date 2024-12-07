package com.estudo.jpa.repositories;

import com.estudo.jpa.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<BookModel, UUID> {
    BookModel findBookModelByTitle(String title);

}
