package com.example.RESUMEBUILDER.controller;

import com.example.RESUMEBUILDER.model.Skills;
import com.example.RESUMEBUILDER.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SkillController {

    @Autowired
    private SkillService skillService;

    @RequestMapping(value="/skills" ,method= RequestMethod.GET)
    public ModelAndView personalForm(String msg){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("skill");
        modelAndView.addObject("skills",new Skills());
        modelAndView.addObject("msg", msg);
        return modelAndView;
    }
    @RequestMapping(value = "/skills", method = RequestMethod.POST)
    public ModelAndView createBookPost(Skills skills, BindingResult bindingResult ) {
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("personalForm");
            modelAndView.addObject("msg", "Failed to Update Details due to some errors");
            modelAndView.addObject("skills", skills);
        }
        else {
            skillService.createSkill(skills);
            modelAndView = personalForm("Personal details has been uploaded");
        }
        return modelAndView;
    }
}
