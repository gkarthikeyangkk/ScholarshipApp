/*package com.tripleS.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tripleS.model.StudentFileDTO;

@Component
@Repository
public class StudentApplicationDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public void createStudentEntity() {
			
		String sql = "INSERT INTO Entity_Details " +
				"(Entity_Type, First_Name) VALUES (?, ?)";
		jdbcTemplate.update(
                sql,
                new Object[] { "Applicant", "John" });
		
	}
	
	public void createStudentFile(StudentFileDTO studentFile) {
		
		String sql = "INSERT INTO Student_File " +
				"(File_No, File_Status, Entity_ID, Created_By, Created_Date) VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(
                sql,
                new Object[] { studentFile.getFileNo(), studentFile.getFileStatus(),
                		studentFile.getEntityId(), studentFile.getCreatedBy(), studentFile.getCreatedDate() });
		
	}
}
*/