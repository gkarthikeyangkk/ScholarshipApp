package com.tripleS.service;

import java.sql.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tripleS.dao.StudentApplicationDAO;
import com.tripleS.dto.StudentFileDTO;

@Controller
@RequestMapping("/studentApplication")
public class StudentApplicationService {

    @Autowired
    StudentApplicationDAO studentApplication;
    
    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody boolean createStudentFile() {
    	StudentFileDTO studentFile = new StudentFileDTO("1", "New", 1001, "John", new Date(new java.util.Date().getTime()));
    	studentApplication.createStudentEntity();
    	studentApplication.createStudentFile(studentFile);
        return true;
    }

}