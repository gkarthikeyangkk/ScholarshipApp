package com.tripleS.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tripleS.model.EntityDetails;
import com.tripleS.model.StudentFile;
import com.tripleS.service.NotificationService;
import com.tripleS.service.StudentFileService;

@Controller
@RequestMapping("/studentApplication")
public class StudentApplicationService {

	private static final Logger logger = LoggerFactory
			.getLogger(StudentApplicationService.class);
	
	@Autowired
	private StudentFileService studentFileService;
	
	@Autowired
    private NotificationService notifyService;
	
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
		dataBinder.registerCustomEditor(Date.class, dateEditor);
    }
	
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
			StudentFile studentFile = studentFileService.findByFileNo(fileNo);
			if(studentFile != null) {
				logger.info("Applicant Name: " + studentFile.getEntityDetails().getFirstName());
				modelAndView.addObject("studentFile", studentFile);
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
	
	@RequestMapping(value="/familyDetails/{fileNo}", method = RequestMethod.GET)
	public ModelAndView familyDetails(@PathVariable("fileNo") int fileNo){
		ModelAndView modelAndView = new ModelAndView();
		if(fileNo > 0) {
			logger.info("Path Variable... File No is " + fileNo);
			StudentFile studentFile = studentFileService.findByFileNo(fileNo);
			if(studentFile != null) {
				logger.info("Applicant Name: " + studentFile.getEntityDetails().getFirstName());
				modelAndView.addObject("studentFile", studentFile);
				modelAndView.setViewName("familyDetails");
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
		return "familyDetails";
	}
	
	@RequestMapping(value="/bankAccountDetails", method = RequestMethod.GET)
	public String bankAccountDetails(Model model){
		logger.info("In the family details Get Request...File No is " + ((StudentFile) model.asMap().get("studentFile")).getFileNo());
		return "bankAccountDetails";
	}
	
	@RequestMapping(value="/familyDetails", params={"addEntityDetails"})
	public String addRow(final StudentFile studentFile, final BindingResult bindingResult) {
	    studentFile.getEntityDetails().getRelatives().add(new EntityDetails());
	    return "familyDetails";
	}

	@RequestMapping(value="/familyDetails", params={"addSchoolEmployerDetails"})
	public String addSchoolEmployer(
	        final StudentFile studentFile, final BindingResult bindingResult, 
	        final HttpServletRequest req) {
	    final Integer rowId = Integer.valueOf(req.getParameter("addSchoolEmployerDetails"));
	    studentFile.getEntityDetails().getRelatives().get(rowId.intValue()).getRelatives().add(new EntityDetails());
	    return "familyDetails";
	}
	
	@RequestMapping(value="/familyDetails", params={"removeEntityDetails"})
	public String removeRow(
	        final StudentFile studentFile, final BindingResult bindingResult, 
	        final HttpServletRequest req) {
	    final Integer rowId = Integer.valueOf(req.getParameter("removeEntityDetails"));
	    studentFile.getEntityDetails().getRelatives().remove(rowId.intValue());
	    return "familyDetails";
	}
	
	@RequestMapping(value="/fragments/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("fragments/home");
		return modelAndView;
	}
	
    @RequestMapping(value = "/basicDetails", method=RequestMethod.POST, params={"saveContinueBasicDetails"})
    public ModelAndView saveContinueStudentFile(@Valid StudentFile studentFile, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    	ModelAndView modelAndView = new ModelAndView();
    	if (bindingResult.hasErrors()) {
        	logger.error("Found validation errors");
        	modelAndView.addObject("studentFile", studentFile);
			modelAndView.setViewName("basicDetails");
		} else {
			logger.info("Found no validation errors");
	    	if(studentFile.getId() > 0) {
	    		logger.info("Existing File ID: " + studentFile.getId());
	    		studentFile = studentFileService.update(studentFile);
	    		logger.info("File ID After Update: " + studentFile.getId());
	    		logger.info(studentFile.getEntityDetails().getFirstName() + "'s basic details updated successfully");
		        notifyService.addInfoMessage(studentFile.getEntityDetails().getFirstName() + "'s basic details updated successfully!!");
	    	} else {
		        studentFile = studentFileService.save(studentFile);
		        logger.info("New File No: " + studentFile.getFileNo());
		        logger.info(studentFile.getEntityDetails().getFirstName() + "'s basic details saved successfully");
		        notifyService.addInfoMessage(studentFile.getEntityDetails().getFirstName() + "'s basic details saved successfully!!");
	    	}
	        //modelAndView.addObject("studentFile", studentFile);
	        redirectAttributes.addFlashAttribute("studentFile", studentFile);
	        modelAndView.setViewName("redirect:/studentApplication/familyDetails");
		}
        return modelAndView;
    }
    
    @RequestMapping(value = "/basicDetails", method=RequestMethod.POST, params={"saveBasicDetails"})
    public ModelAndView saveStudentFile(@Valid StudentFile studentFile, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    	ModelAndView modelAndView = new ModelAndView();
    	if (bindingResult.hasErrors()) {
        	logger.error("Found validation errors");
        	modelAndView.addObject("studentFile", studentFile);
			modelAndView.setViewName("basicDetails");
		} else {
			logger.info("Found no validation errors");
	    	if(studentFile.getId() > 0) {
	    		logger.info("Existing File ID: " + studentFile.getId());
	    		studentFile = studentFileService.update(studentFile);
	    		logger.info("File ID After Update: " + studentFile.getId());
	    		logger.info(studentFile.getEntityDetails().getFirstName() + "'s basic details updated successfully");
		        notifyService.addInfoMessage(studentFile.getEntityDetails().getFirstName() + "'s basic details updated successfully!!");
	    	} else {
		        studentFile = studentFileService.save(studentFile);
		        logger.info("New File No: " + studentFile.getFileNo());
		        logger.info(studentFile.getEntityDetails().getFirstName() + "'s basic details saved successfully");
		        notifyService.addInfoMessage(studentFile.getEntityDetails().getFirstName() + "'s basic details saved successfully!!");
	    	}
	        //modelAndView.addObject("studentFile", studentFile);
	    	modelAndView.setViewName("basicDetails");
		}
        return modelAndView;
    }
    
    @RequestMapping(value = "/familyDetails", method=RequestMethod.POST, params={"saveContinueFamilyDetails"})
    public ModelAndView saveContinueFamilyDetails(@Valid StudentFile studentFile, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    	ModelAndView modelAndView = new ModelAndView();
    	if (bindingResult.hasErrors()) {
        	logger.error("Found validation errors");
        	modelAndView.addObject("studentFile", studentFile);
			modelAndView.setViewName("basicDetails");
		} else {
			logger.info("Found no validation errors");
	    	if(studentFile.getId() > 0) {
	    		logger.info("Existing File ID: " + studentFile.getId());
	    		studentFile = studentFileService.update(studentFile);
	    		logger.info("File ID After Update: " + studentFile.getId());
	    		logger.info(studentFile.getEntityDetails().getFirstName() + "'s family details updated successfully");
		        notifyService.addInfoMessage(studentFile.getEntityDetails().getFirstName() + "'s basic details updated successfully!!");
	    	} else {
		        studentFile = studentFileService.save(studentFile);
		        logger.info("New File No: " + studentFile.getFileNo());
		        logger.info(studentFile.getEntityDetails().getFirstName() + "'s family details saved successfully");
		        notifyService.addInfoMessage(studentFile.getEntityDetails().getFirstName() + "'s family details saved successfully!!");
	    	}
	        //modelAndView.addObject("studentFile", studentFile);
	        redirectAttributes.addFlashAttribute("studentFile", studentFile);
	        modelAndView.setViewName("redirect:/studentApplication/bankAccountDetails");
		}
        return modelAndView;
    }
    
    @RequestMapping(value = "/familyDetails", method=RequestMethod.POST, params={"saveFamilyDetails"})
    public ModelAndView saveFamilyDetails(@Valid StudentFile studentFile, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    	ModelAndView modelAndView = new ModelAndView();
    	if (bindingResult.hasErrors()) {
        	logger.error("Found validation errors");
        	modelAndView.addObject("studentFile", studentFile);
		} else {
			logger.info("Found no validation errors");
	    	if(studentFile.getId() > 0) {
	    		logger.info("Existing File ID: " + studentFile.getId());
	    		
	    		for (int i = 0; i < studentFile.getEntityDetails().getRelatives().size(); i++) {
	    			studentFile.getEntityDetails().getRelatives().get(i).setApplicant(studentFile.getEntityDetails());
	    		}
	    		
	    		studentFile = studentFileService.update(studentFile);
	    		logger.info("File ID After Update: " + studentFile.getId());
	    		logger.info(studentFile.getEntityDetails().getFirstName() + "'s family details updated successfully");
		        notifyService.addInfoMessage(studentFile.getEntityDetails().getFirstName() + "'s family details updated successfully!!");
	    	} else {
		        studentFile = studentFileService.save(studentFile);
		        logger.info("New File No: " + studentFile.getFileNo());
		        logger.info(studentFile.getEntityDetails().getFirstName() + "'s family details saved successfully");
		        notifyService.addInfoMessage(studentFile.getEntityDetails().getFirstName() + "'s family details saved successfully!!");
	    	}
		}
    	modelAndView.setViewName("familyDetails");
        return modelAndView;
    }
}