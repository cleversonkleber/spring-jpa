package com.estudo.jpa.repositories;

import com.estudo.jpa.models.BookModel;
import com.estudo.jpa.models.PublisherModel;
import com.estudo.jpa.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<ReviewModel, UUID> {

    
}
