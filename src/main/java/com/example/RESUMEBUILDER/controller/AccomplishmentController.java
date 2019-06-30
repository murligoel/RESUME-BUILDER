package com.example.RESUMEBUILDER.controller;

import com.example.RESUMEBUILDER.model.Accomplishment;
import com.example.RESUMEBUILDER.service.AccomplishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccomplishmentController {

    @Autowired
    private AccomplishmentService accomplishmentService;

    public static Long fetched_id_accomplishment;

    @RequestMapping(value="/accomplishments" ,method= RequestMethod.GET)
    public ModelAndView accomplishmentsForm(String msg, Long fetched_id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("accomplishment");
        modelAndView.addObject("accomplishments",new Accomplishment());
        modelAndView.addObject("msg", msg);
        modelAndView.addObject("fetched_id",fetched_id);
        return modelAndView;
    }
    @RequestMapping(value = "/skills", method = RequestMethod.POST)
    public ModelAndView createAccomplishments(Accomplishment accomplishment, BindingResult bindingResult ) {
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("accomplishment");
            modelAndView.addObject("msg", "Failed to Update Accomplishments due to some errors");
            modelAndView.addObject("accomplishments", accomplishment);
        }
        else {
            accomplishmentService.createAccomplishments(accomplishment);
            fetched_id_accomplishment = accomplishment.getId();
            modelAndView = accomplishmentsForm("Skills has been uploaded",AccomplishmentController.fetched_id_accomplishment);
        }
        return modelAndView;
    }
}
