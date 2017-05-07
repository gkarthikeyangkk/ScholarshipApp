package com.tripleS.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tripleS.model.EntityDetails;
import com.tripleS.model.StudentFile;
import com.tripleS.model.User;
import com.tripleS.repository.StudentFileRepository;
import com.tripleS.service.UserService;

@Controller
@RequestMapping("/studentApplication")
public class StudentApplicationService {

	@Autowired
    StudentFileRepository studentFileRepository;
	
	@Autowired
	private UserService userService;
    
	@RequestMapping(value="/basicDetails", method = RequestMethod.GET)
	public ModelAndView newCase(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("applicant", new EntityDetails());
		modelAndView.setViewName("basicDetails");
		return modelAndView;
	}
	
	@RequestMapping(value="/familyDetails", method = RequestMethod.GET)
	public ModelAndView familyDetails(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("familyMembers", new ArrayList<EntityDetails>());
		modelAndView.setViewName("familyDetails");
		return modelAndView;
	}
	
	@RequestMapping(value="/fragments/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmailID(auth.getName());
		modelAndView.addObject("userName", user.getFirstName());
		modelAndView.setViewName("fragments/home");
		return modelAndView;
	}
	
    @RequestMapping(value = "/basicDetails", method=RequestMethod.POST)
    public ModelAndView createStudentFile(@Valid EntityDetails applicant, BindingResult bindingResult) {
    	ModelAndView modelAndView = new ModelAndView();
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	
    	StudentFile sf1 = new StudentFile();
        sf1.setFileNo(studentFileRepository.getMaxFileNo() + 1);
        sf1.setFileStatus("New");
        sf1.setCreatedBy(auth.getName());
        sf1.setCreatedDate(new Date(new java.util.Date().getTime()));
        
        applicant.setType("Applicant");
        
        sf1.setEntityDetails(applicant);
        
        studentFileRepository.save(sf1);
		
        modelAndView.addObject("familyMembers", new ArrayList<EntityDetails>());
        modelAndView.setViewName("redirect:/studentApplication/familyDetails");
		//modelAndView.setViewName("familyDetails");
			
		return modelAndView;
    	
    }

}