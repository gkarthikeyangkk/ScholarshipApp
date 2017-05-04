package com.tripleS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tripleS.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailID(String emailID);
}
