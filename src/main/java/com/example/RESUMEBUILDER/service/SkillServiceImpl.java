package com.example.RESUMEBUILDER.service;

import com.example.RESUMEBUILDER.model.Skills;
import com.example.RESUMEBUILDER.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("skillService")
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public Skills createSkill(Skills skills) {
        return skillRepository.save(skills);
    }
}
