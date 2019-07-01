package com.example.RESUMEBUILDER.service;

import com.example.RESUMEBUILDER.model.Interests;

public interface InterestService{

    Interests createInterests(Interests interests);
    Interests getInterestsById(Long id);
}
