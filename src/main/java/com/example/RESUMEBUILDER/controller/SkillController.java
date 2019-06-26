package com.example.RESUMEBUILDER.controller;

import com.example.RESUMEBUILDER.model.Skills;
import com.example.RESUMEBUILDER.service.SkillService;
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

    @RequestMapping(value="/skills" ,method= RequestMethod.GET)
    public ModelAndView personalForm(String msg, Long fetched_id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("skill");
        modelAndView.addObject("skills",new Skills());
        modelAndView.addObject("msg", msg);
        modelAndView.addObject("fetched_id",fetched_id);
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
            modelAndView = personalForm("Skills has been uploaded",skills.getId());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/skillView/{id}",method = RequestMethod.GET)
    public ModelAndView getSkills(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("skillView");
        modelAndView.addObject("skills",skillService.getSkillById(id));
        return modelAndView;
    }
}
