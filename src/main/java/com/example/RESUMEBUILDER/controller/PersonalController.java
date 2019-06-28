package com.example.RESUMEBUILDER.controller;

import com.example.RESUMEBUILDER.model.Personal;
import com.example.RESUMEBUILDER.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    public static Long personalFormId;


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
            personalFormId = personal.getId();
            modelAndView = personalForm("Personal details has been uploaded",PersonalController.personalFormId);
        }
        return modelAndView;
    }

    @RequestMapping(value="/personal/update/{id}" ,method= RequestMethod.GET)
    public ModelAndView editPersonalForm(String msg , @PathVariable  Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("personalForm");
        Personal personalForm = personalService.getPersonalDetails(id);
        modelAndView.addObject("personal",personalForm);
        modelAndView.addObject("msg", msg);


        return modelAndView;
    }

    @RequestMapping(value = "/personal/update/{fetched_id}", method = RequestMethod.PUT)
    public ModelAndView edit(@Valid Personal personal, @PathVariable Long fetched_id ) {
        ModelAndView modelAndView = new ModelAndView();
            personalService.updatePersonalDetails(personal,fetched_id);
            modelAndView = editPersonalForm("Personal details has been updated",PersonalController.personalFormId);

        return modelAndView;
    }
}
