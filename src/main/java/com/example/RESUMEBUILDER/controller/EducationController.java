package com.example.RESUMEBUILDER.controller;

import com.example.RESUMEBUILDER.model.Education;
import com.example.RESUMEBUILDER.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class EducationController {

    @Autowired
    private EducationService educationService;

    public static Long formId;

    @RequestMapping(value = "/education",method = RequestMethod.GET)
    public ModelAndView personalForm(String msg , Long fetched_id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("educationForm");
        modelAndView.addObject("education",new Education());
        modelAndView.addObject("msg", msg);
        modelAndView.addObject("fetched_id",fetched_id);
        return modelAndView;
    }

    @RequestMapping(value = "/education",method = RequestMethod.POST)
    public ModelAndView createBookPost(@Valid Education education, BindingResult bindingResult ) {
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("educationForm");
            modelAndView.addObject("msg", "Failed to Update Details due to some errors");
            modelAndView.addObject("education", education);
        }
        else {
            educationService.createEducationalDetails(education);
            formId = PersonalController.personalFormId;
            modelAndView = personalForm("Educational details has been uploaded",education.getId());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/resume1/{id}",method = RequestMethod.GET)
    public ModelAndView getPersonalDetails(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("resume_template1");
        modelAndView.addObject("personalId",educationService.getEducationDetails(id));
        return modelAndView;
    }
//      return "redirect:/showData";
}
