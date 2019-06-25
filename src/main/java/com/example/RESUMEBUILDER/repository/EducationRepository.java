package com.example.RESUMEBUILDER.repository;

import com.example.RESUMEBUILDER.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
}
