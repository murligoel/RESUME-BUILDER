package com.example.RESUMEBUILDER.controller;

import com.example.RESUMEBUILDER.model.Skills;
import com.example.RESUMEBUILDER.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SkillController {

    @Autowired
    private SkillService skillService;

    @Autowired
    private PersonalService personalService;

    @Autowired
    private EducationService educationService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private AccomplishmentService accomplishmentService;

    @Autowired
    private InterestService interestService;

    public static Long skillFormId;

    @RequestMapping(value="/skills" ,method= RequestMethod.GET)
    public ModelAndView skillsForm(String msg, Long fetched_id , Long fetched_id_personal, Long fetched_id_education , Long fetched_id_project , Long fetched_id_accomplishment,Long fetched_id_interests){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("skill");
        modelAndView.addObject("skills",new Skills());
        modelAndView.addObject("msg", msg);
        modelAndView.addObject("fetched_id",fetched_id);
        modelAndView.addObject("fetched_id_personal",fetched_id_personal);
        modelAndView.addObject("fetched_id_education",fetched_id_education);
        modelAndView.addObject("fetched_id_project",fetched_id_project);
        modelAndView.addObject("fetched_id_accomplishment",fetched_id_accomplishment);
        modelAndView.addObject("fetched_id_interests",fetched_id_interests);
        return modelAndView;
    }
    @RequestMapping(value = "/skills", method = RequestMethod.POST)
    public ModelAndView createSkills(Skills skills, BindingResult bindingResult ) {
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("skill");
            modelAndView.addObject("msg", "Failed to Update Skills due to some errors");
            modelAndView.addObject("skills", skills);
        }
        else {
            skills.getSkill().spliterator();
            skillService.createSkill(skills);
            skillFormId = skills.getId();
            modelAndView = skillsForm("Skills has been uploaded",skillFormId,PersonalController.personalFormId,EducationController.educationFormId,ProjectController.projectFormId,AccomplishmentController.fetched_id_accomplishment,InterestController.interestFormId);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/skillView/{id1}/{id2}/{id3}/{id4}/{id5}/{id6}",method = RequestMethod.GET)
    public ModelAndView getSkills(@PathVariable(value = "id1") Long id1,@PathVariable(value = "id2") Long id2 , @PathVariable(value = "id3") Long id3,@PathVariable(value = "id4") Long id4,@PathVariable(value = "id5") Long id5,@PathVariable(value = "id6") Long id6){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("skillView");
        modelAndView.addObject("personal",personalService.getPersonalDetails(id1));
        modelAndView.addObject("education",educationService.getEducationDetails(id2));
        modelAndView.addObject("skills",skillService.getSkillById(id3));
        modelAndView.addObject("projects",projectService.getProjectById(id4));
        modelAndView.addObject("accomplishments",accomplishmentService.getAccomplishmentById(id5));
        modelAndView.addObject("interests",interestService.getInterestsById(id6));
        return modelAndView;
    }
}
