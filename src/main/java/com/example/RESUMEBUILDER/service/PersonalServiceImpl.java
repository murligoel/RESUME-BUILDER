package com.example.RESUMEBUILDER.service;


import com.example.RESUMEBUILDER.model.Personal;
import com.example.RESUMEBUILDER.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personalService")
public class PersonalServiceImpl implements PersonalService {

    @Autowired
    private PersonalRepository personalRepository;
    @Override
    public Personal createPersonal(Personal personal) {
        return personalRepository.save(personal);
    }

    @Override
    public Personal getPersonalDetails(Long id) {
        return personalRepository.findById(id).orElse(null);
    }

    @Override
    public Personal updatePersonalDetails(Personal personal, Long id) {
        personal.setId(id);
        return personalRepository.save(personal);
    }
}
