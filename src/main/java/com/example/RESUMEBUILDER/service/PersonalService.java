package com.example.RESUMEBUILDER.service;

import com.example.RESUMEBUILDER.model.Personal;

public interface PersonalService {

    Personal createPersonal(Personal personal);
    Personal getPersonalDetails(Long id);
    Personal updatePersonalDetails(Personal personal, Long id);

}
