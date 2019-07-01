package com.example.RESUMEBUILDER.service;

import com.example.RESUMEBUILDER.model.Education;

public interface EducationService {
    Education createEducationalDetails(Education education);
    Education getEducationDetails(Long id);
    Education updateEducationDetails(Education education, Long id);
}
