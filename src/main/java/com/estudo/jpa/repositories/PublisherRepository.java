package com.estudo.jpa.repositories;

import com.estudo.jpa.models.BookModel;
import com.estudo.jpa.models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepository extends JpaRepository<PublisherModel, UUID> {

    
}
