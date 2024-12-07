package com.estudo.jpa.repositories;

import com.estudo.jpa.models.AuthorModel;
import com.estudo.jpa.models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {

    
}
