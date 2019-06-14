package com.example.RESUMEBUILDER.repository;

import com.example.RESUMEBUILDER.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
