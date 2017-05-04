package com.tripleS.service;

import com.tripleS.model.User;

public interface UserService {
	public User findUserByEmailID(String emailID);
	public void saveUser(User user);
}
