package com.example.RESUMEBUILDER.service;

import com.example.RESUMEBUILDER.model.Accomplishment;
import com.example.RESUMEBUILDER.repository.AccomplishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accomplishmentService")
public class AccomplishmentServiceImpl implements AccomplishmentService{

    @Autowired
    private AccomplishmentRepository accomplishmentRepository;

    @Override
    public Accomplishment createAccomplishments(Accomplishment accomplishment) {
        return accomplishmentRepository.save(accomplishment);
    }

    @Override
    public Accomplishment getAccomplishmentById(Long id) {
        return accomplishmentRepository.findById(id).orElse(null);
    }
}
