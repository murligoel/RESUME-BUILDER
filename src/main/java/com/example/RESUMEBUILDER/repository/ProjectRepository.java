package com.example.RESUMEBUILDER.repository;

import com.example.RESUMEBUILDER.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
