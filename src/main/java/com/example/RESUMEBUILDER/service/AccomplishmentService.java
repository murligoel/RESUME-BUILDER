package com.example.RESUMEBUILDER.service;

import com.example.RESUMEBUILDER.model.Accomplishment;

public interface AccomplishmentService {

    Accomplishment createAccomplishments(Accomplishment accomplishment);

    Accomplishment getAccomplishmentById(Long id);
}
