package com.tripleS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripleS.model.StudentFile;

public interface StudentFileRepository extends JpaRepository<StudentFile, Integer> {

}
