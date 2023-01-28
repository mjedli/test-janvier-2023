/**
 * 
 */
package com.mjedli.testjanvier2023.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mjedli.testjanvier2023.model.User;

/**
 * @author mjedli
 *
 */
@Repository
public class UserRepository {
	
	@Autowired
	private MongoOperations mongoOperations;
	
	public List<User> findUserByEmail(User user) {
		Query searchQuery = new Query(Criteria.where("email").is(user.getEmail()));
		return mongoOperations.find(searchQuery, User.class);
	}

	public User insert(User user) {
		return mongoOperations.insert(user);
	}

	public List<User> findAllUsers() {
		Query searchQuery = new Query();
		return mongoOperations.find(searchQuery, User.class);
	}

	public User findUserById(Long id) {
		Query searchQuery = new Query(Criteria.where("id").is(id));
		return mongoOperations.findOne(searchQuery, User.class);
	}

}
