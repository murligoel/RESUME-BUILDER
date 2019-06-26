package com.example.RESUMEBUILDER.service;

import com.example.RESUMEBUILDER.model.Skills;
import com.example.RESUMEBUILDER.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("skillService")
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public Skills createSkill(Skills skills) {
        return skillRepository.save(skills);
    }

    @Override
    public List<Skills> getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Skills getSkillById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }
}
