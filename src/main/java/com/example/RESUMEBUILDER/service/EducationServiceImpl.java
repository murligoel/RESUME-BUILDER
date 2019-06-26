package com.example.RESUMEBUILDER.service;

import com.example.RESUMEBUILDER.model.Education;
import com.example.RESUMEBUILDER.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("educationService")
public class EducationServiceImpl implements EducationService{

    @Autowired
    private EducationRepository educationRepository;

    @Override
    public Education createEducationalDetails(Education education) {
        return educationRepository.save(education);
    }
}