package com.tripleS.service;

import java.util.List;
import com.tripleS.model.EntityDetails;

public interface EntityDetailsService {
	List<EntityDetails> findRelativesByFileNo(int fileNo);
	EntityDetails findApplicant(int fileNo);
	EntityDetails save(EntityDetails entityDetails);
	void delete(int id);
	EntityDetails findById(int id);
}
