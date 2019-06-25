package com.example.RESUMEBUILDER.service;

import com.example.RESUMEBUILDER.model.Skills;

import java.util.List;

public interface SkillService {
    Skills createSkill(Skills skills);
    List<Skills> getAllSkills();
}
