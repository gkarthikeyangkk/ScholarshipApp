package com.tripleS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tripleS.model.StudentFile;

public interface StudentFileRepository extends JpaRepository<StudentFile, Integer> {
	
	@Query("Select MAX(s.fileNo) from StudentFile s")
	Integer getMaxFileNo();
	
	@Query("Select COUNT(*) from StudentFile where fileNo = :fileId")
	Integer checkIfExists(@Param("fileId") String fileId);

	StudentFile findByFileNo(int fileNo);
}
