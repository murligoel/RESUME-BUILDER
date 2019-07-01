package com.example.RESUMEBUILDER.service;

import com.example.RESUMEBUILDER.model.Interests;
import com.example.RESUMEBUILDER.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("interestService")
public class InterestServiceImpl implements InterestService {

    @Autowired
    private InterestRepository interestRepository;

    @Override
    public Interests createInterests(Interests interests) {
        return interestRepository.save(interests);
    }

    @Override
    public Interests getInterestsById(Long id) {
        return interestRepository.findById(id).orElse(null);
    }
}
