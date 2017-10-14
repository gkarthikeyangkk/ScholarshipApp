package com.tripleS.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.tripleS.model.StudentFile;
import com.tripleS.repository.StudentFileRepository;

@Service
public class StudentFileServiceImpl implements StudentFileService {

	@Autowired
    StudentFileRepository studentFileRepository;
	
	@Override
	public StudentFile findByFileNo(int fileNo) {
		return studentFileRepository.findByFileNo(fileNo);
	}

	@Override
	public StudentFile update(StudentFile studentFile) {
		studentFile = studentFileRepository.save(studentFile);
		return studentFile;
	}

	@Override
	public StudentFile save(StudentFile studentFile) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		String generatedFileId = generateFileId();
		while(studentFileRepository.checkIfExists(generatedFileId) > 0) {
			generatedFileId = generateFileId();
    	}
        studentFile.setFileNo(generatedFileId);
        studentFile.setFileStatus("New");
        studentFile.setCreatedBy(auth.getName());
        studentFile.setCreatedDate(new Date());
        //studentFile.setCreatedDate(new Date(new java.util.Date().getTime()));
        studentFile.getEntityDetails().setType("Applicant");
        studentFile = studentFileRepository.save(studentFile);
		return studentFile;
	}
	
	private String generateFileId(){
		String fileId = new String(RandomStringUtils.randomAlphanumeric(18).toUpperCase());
		return fileId;
        /*MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(fileId.getBytes());

        byte byteData[] = md.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
    	return fileId;*/
	}
	

}
