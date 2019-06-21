package com.example.RESUMEBUILDER.controller;

import com.example.RESUMEBUILDER.model.Personal;
import com.example.RESUMEBUILDER.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PersonalController {

    @Autowired
    private PersonalService personalService;


    @RequestMapping(value="/personal" ,method= RequestMethod.GET)
    public ModelAndView personalForm(String msg , Long fetched_id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("personalForm");
        modelAndView.addObject("personal",new Personal());
        modelAndView.addObject("msg", msg);
        modelAndView.addObject("fetched_id",fetched_id);
        return modelAndView;
    }

    @RequestMapping(value = "/personal", method = RequestMethod.POST)
    public ModelAndView createBookPost(@Valid Personal personal, BindingResult bindingResult ) {
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("personalForm");
            modelAndView.addObject("msg", "Failed to Update Details due to some errors");
            modelAndView.addObject("personal", personal);
        }
        else {
            personalService.createPersonal(personal);
            modelAndView = personalForm("Personal details has been uploaded",personal.getId());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/resume1/{id}",method = RequestMethod.GET)
    public ModelAndView getPersonalDetails(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("resume_template1");
        modelAndView.addObject("personalId",personalService.getPersonalDetails(id));
        return modelAndView;
    }
}
