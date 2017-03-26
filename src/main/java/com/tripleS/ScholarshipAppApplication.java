package com.tripleS;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tripleS.model.EntityDetails;
import com.tripleS.model.StudentFile;
import com.tripleS.repository.StudentFileRepository;

@SpringBootApplication
public class ScholarshipAppApplication implements CommandLineRunner{

	/*@Autowired
    private StudentFileRepository studentFileRepository;*/
	
	public static void main(String[] args) {
		SpringApplication.run(ScholarshipAppApplication.class, args);
	}
	
	@Override
    public void run(String... strings) throws Exception {
        // save a couple of books
        /*List<StudentFile> studentFiles = new ArrayList<>();
        
        StudentFile sf1 = new StudentFile();
        EntityDetails ed1 = new EntityDetails();
        
        sf1.setFileNo("2");
        sf1.setFileStatus("New");
        sf1.setCreatedBy("Doe");
        sf1.setCreatedDate(new Date(new java.util.Date().getTime()));
        ed1.setType("Applicant");
        ed1.setFirstName("Doe");
        
        sf1.setEntityDetails(ed1);
        
        studentFileRepository.save(studentFiles);
        System.out.println(sf1.toString());*/
	}
}
