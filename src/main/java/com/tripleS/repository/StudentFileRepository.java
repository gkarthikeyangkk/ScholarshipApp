package com.tripleS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tripleS.model.StudentFile;

public interface StudentFileRepository extends JpaRepository<StudentFile, Integer> {
	
	@Query("Select MAX(s.fileNo) from StudentFile s")
	Integer getMaxFileNo();

	StudentFile findByFileNo(int fileNo);
}
