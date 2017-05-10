package com.tripleS.controller;

import java.sql.Date;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.tripleS.model.StudentFile;
import com.tripleS.repository.StudentFileRepository;
import com.tripleS.service.NotificationService;

@Controller
@RequestMapping("/studentApplication")
public class StudentApplicationService {

	private static final Logger logger = LoggerFactory
			.getLogger(StudentApplicationService.class);
	
	@Autowired
    StudentFileRepository studentFileRepository;
	
	@Autowired
    private NotificationService notifyService;
	
	@RequestMapping(value="/basicDetails", method = RequestMethod.GET)
	public ModelAndView newCase(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("studentFile", new StudentFile());
		modelAndView.setViewName("basicDetails");
		return modelAndView;
	}
	
	@RequestMapping(value="/basicDetails/{fileNo}", method = RequestMethod.GET)
	public ModelAndView basicDetails(@PathVariable("fileNo") int fileNo){
		ModelAndView modelAndView = new ModelAndView();
		if(fileNo > 0) {
			logger.info("Path Variable... File No is " + fileNo);
			StudentFile sf = studentFileRepository.findByFileNo(fileNo);
			if(sf != null) {
				logger.info("Applicant Name: " + sf.getEntityDetails().getFirstName());
				modelAndView.addObject("studentFile", sf);
				modelAndView.setViewName("basicDetails");
				return modelAndView;
			} else {
				logger.error("Invalid case number: " + fileNo);
				notifyService.addErrorMessage("Invalid case number: " + fileNo);
				modelAndView.setViewName("fragments/home");
				return modelAndView;
			}
		} else {
			logger.error("Invalid case number: " + fileNo);
			notifyService.addErrorMessage("Invalid case number: " + fileNo);
			modelAndView.setViewName("fragments/home");
			return modelAndView;
		}
	}
	
	@RequestMapping(value="/familyDetails", method = RequestMethod.GET)
	public String familyDetails(Model model){
		logger.info("In the family details Get Request...File No is " + ((StudentFile) model.asMap().get("studentFile")).getFileNo());
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
    public ModelAndView createStudentFile(@Valid StudentFile studentFile, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    	ModelAndView modelAndView = new ModelAndView();
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	
        studentFile.setFileNo(studentFileRepository.getMaxFileNo() + 1);
        studentFile.setFileStatus("New");
        studentFile.setCreatedBy(auth.getName());
        studentFile.setCreatedDate(new Date(new java.util.Date().getTime()));
        studentFile.getEntityDetails().setType("Applicant");
        if (bindingResult.hasErrors()) {
        	logger.error("Found errors");
        	modelAndView.addObject("studentFile", studentFile);
			modelAndView.setViewName("basicDetails");
		} else {
			logger.info("Found no errors");
	        studentFile = studentFileRepository.save(studentFile);
	        logger.info("File No: " + studentFile.getFileNo());
			
	        //modelAndView.addObject("studentFile", studentFile);
	        logger.info(studentFile.getEntityDetails().getFirstName() + "'s basic details saved successfully");
	        notifyService.addInfoMessage(studentFile.getEntityDetails().getFirstName() + "'s basic details saved successfully");
	        redirectAttributes.addFlashAttribute("studentFile", studentFile);
	        modelAndView.setViewName("redirect:/studentApplication/familyDetails");
		}
        return modelAndView;
    }
}