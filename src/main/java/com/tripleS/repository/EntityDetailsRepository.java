package com.tripleS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tripleS.model.EntityDetails;

public interface EntityDetailsRepository extends JpaRepository<EntityDetails, Integer> {

	EntityDetails findById(int id);
}
