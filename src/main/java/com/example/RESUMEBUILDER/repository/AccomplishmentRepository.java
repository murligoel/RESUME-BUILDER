package com.example.RESUMEBUILDER.repository;

import com.example.RESUMEBUILDER.model.Accomplishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccomplishmentRepository extends JpaRepository<Accomplishment, Long> {

}
