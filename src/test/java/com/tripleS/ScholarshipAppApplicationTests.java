package com.tripleS;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tripleS.repository.StudentFileRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScholarshipAppApplicationTests {

	@Autowired
    StudentFileRepository studentFileRepository;
	
	@Test
	public void contextLoads() {
	}

}
