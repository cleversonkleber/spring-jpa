package com.estudo.jpa.services;


import com.estudo.jpa.dtos.BookRecordDto;
import com.estudo.jpa.models.BookModel;
import com.estudo.jpa.models.ReviewModel;
import com.estudo.jpa.repositories.AuthorRepository;
import com.estudo.jpa.repositories.BookRepository;
import com.estudo.jpa.repositories.PublisherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;


    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    public List<BookModel> getAllBoocks(){
        return bookRepository.findAll();
    }
    @Transactional
    public BookModel saveBook(BookRecordDto bookRecordDto){
        BookModel bookModel = new BookModel();
        bookModel.setTitle(bookRecordDto.title());
        bookModel.setPublisher(publisherRepository.findById(bookRecordDto.publisherId()).get());
        bookModel.setAuthors(authorRepository.findAllById(bookRecordDto.authorIds()).stream().collect(Collectors.toSet()));

        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setComment(bookRecordDto.reviewComment());
        reviewModel.setBook(bookModel);
        bookModel.setReview(reviewModel);
        return bookRepository.save(bookModel);
        
    }

    @Transactional
    public void deleteBook(UUID id){
        bookRepository.deleteById(id);
    }

}
