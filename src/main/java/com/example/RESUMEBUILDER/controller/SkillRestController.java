package com.example.RESUMEBUILDER.controller;

import com.example.RESUMEBUILDER.model.Skills;
import com.example.RESUMEBUILDER.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkillRestController {

    @Autowired
    private SkillService skillService;

    @RequestMapping(value = "/skills/get", method = RequestMethod.GET)
    public List<Skills> getAllBooks(){
        return skillService.getAllSkills();
    }
}
