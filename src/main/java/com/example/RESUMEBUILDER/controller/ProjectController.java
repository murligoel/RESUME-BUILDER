package com.example.RESUMEBUILDER.controller;

import com.example.RESUMEBUILDER.model.Project;
import com.example.RESUMEBUILDER.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    public static Long projectFormId;

    @RequestMapping(value="/projects" ,method= RequestMethod.GET)
    public ModelAndView projectsForm(String msg, Long fetched_id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("project");
        modelAndView.addObject("projects",new Project());
        modelAndView.addObject("msg", msg);
        modelAndView.addObject("fetched_id",fetched_id);
        return modelAndView;
    }
    @RequestMapping(value = "/projects", method = RequestMethod.POST)
    public ModelAndView createProjects(Project project, BindingResult bindingResult ) {
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("skill");
            modelAndView.addObject("msg", "Failed to Update Skills due to some errors");
            modelAndView.addObject("projects", project);
        }
        else {
//            skills.getSkill().spliterator();
            projectService.createdProject(project);
            projectFormId = project.getId();
            modelAndView = projectsForm("Skills has been uploaded",projectFormId);
        }
        return modelAndView;
    }
}
