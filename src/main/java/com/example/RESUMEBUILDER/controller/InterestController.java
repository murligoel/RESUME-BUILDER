package com.example.RESUMEBUILDER.controller;

import com.example.RESUMEBUILDER.model.Interests;
import com.example.RESUMEBUILDER.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InterestController {

    @Autowired
    private InterestService interestService;

    public static Long interestFormId;

    @RequestMapping(value="/interests" ,method= RequestMethod.GET)
    public ModelAndView interestsForm(String msg, Long fetched_id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("interest");
        modelAndView.addObject("interests",new Interests());
        modelAndView.addObject("msg", msg);
        modelAndView.addObject("fetched_id",fetched_id);
        return modelAndView;
    }

    @RequestMapping(value = "/interests", method = RequestMethod.POST)
    public ModelAndView createInterests(Interests interests, BindingResult bindingResult ) {
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("interest");
            modelAndView.addObject("msg", "Failed to Update interests due to some errors");
            modelAndView.addObject("interests", interests);
        }
        else {
//            interests.getInterests().spliterator();
            interestService.createInterests(interests);
            interestFormId = interests.getId();
            modelAndView = interestsForm("Interests has been uploaded",interestFormId);
        }
        return modelAndView;
    }
}
