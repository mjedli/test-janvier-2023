/**
 * 
 */
package com.mjedli.testjanvier2023.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjedli.testjanvier2023.model.User;

/**
 * @author mjedli
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> findUserByEmail(User user) {
		return userRepository.findUserByEmail(user);
	}

	public User insert(User user) {
		return userRepository.insert(user);
	}

	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}

	public User findUserById(Long id) {
		return userRepository.findUserById(id);
	}
	
}
