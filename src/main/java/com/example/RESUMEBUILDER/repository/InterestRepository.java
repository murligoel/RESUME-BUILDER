package com.example.RESUMEBUILDER.repository;

import com.example.RESUMEBUILDER.model.Interests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepository extends JpaRepository<Interests , Long> {
}
