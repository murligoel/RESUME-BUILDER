package com.example.RESUMEBUILDER.service;

import com.example.RESUMEBUILDER.model.Project;

public interface ProjectService {
    Project createdProject(Project project);
    Project getProjectById(Long id);
}
