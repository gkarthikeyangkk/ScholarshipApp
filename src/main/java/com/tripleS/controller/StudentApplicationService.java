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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		modelAndView.addObject("applicantFile", new StudentFile());
		modelAndView.setViewName("basicDetails");
		return modelAndView;
	}
	
	@RequestMapping(value="/basicDetails/{fileNo}", method = RequestMethod.GET)
	public ModelAndView basicDetails(@PathVariable("fileNo") int fileNo){
		System.out.println("Path Variable... File No is " + fileNo);
		StudentFile sf = studentFileRepository.findByFileNo(fileNo);
		System.out.println("Applicant Name: " + sf.getEntityDetails().getFirstName());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("applicantFile", sf);
		modelAndView.setViewName("basicDetails");
		return modelAndView;
	}
	
	@RequestMapping(value="/familyDetails", method = RequestMethod.GET)
	public String familyDetails(Model model){
		System.out.println("In the family details Get Request...File No is " + ((StudentFile) model.asMap().get("applicantFile")).getFileNo());
		//ModelAndView modelAndView = new ModelAndView();
		//modelAndView.addObject("familyMembers", new ArrayList<EntityDetails>());
		//modelAndView.setViewName("familyDetails");
		return "familyDetails";
	}
	
	@RequestMapping(value="/fragments/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmailID(auth.getName());
		modelAndView.addObject("userName", user.getFirstName());*/
		modelAndView.setViewName("fragments/home");
		return modelAndView;
	}
	
    @RequestMapping(value = "/basicDetails", method=RequestMethod.POST)
    public ModelAndView createStudentFile(@Valid StudentFile applicantFile, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    	ModelAndView modelAndView = new ModelAndView();
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	
        applicantFile.setFileNo(studentFileRepository.getMaxFileNo() + 1);
        applicantFile.setFileStatus("New");
        applicantFile.setCreatedBy(auth.getName());
        applicantFile.setCreatedDate(new Date(new java.util.Date().getTime()));
        applicantFile.getEntityDetails().setType("Applicant");
        
        applicantFile = studentFileRepository.save(applicantFile);
        System.out.println("File No: " + applicantFile.getFileNo());
		
        //modelAndView.addObject("applicantFile", applicantFile);
        redirectAttributes.addFlashAttribute("applicantFile", applicantFile);
        modelAndView.setViewName("redirect:/studentApplication/familyDetails");
			
		return modelAndView;
    	
    }

}