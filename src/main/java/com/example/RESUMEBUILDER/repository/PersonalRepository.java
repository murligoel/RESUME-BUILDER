package com.example.RESUMEBUILDER.repository;

import com.example.RESUMEBUILDER.model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends JpaRepository<Personal , Long> {

}
