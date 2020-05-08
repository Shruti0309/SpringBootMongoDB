package com.mongoDB.connector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.mongoDB.connector.model.User;

/*Add the following code to the service class where we will call the methods
 *  of the Dao interface to handle the sql operations.*/

@Service
public interface UserService {

	public void createUser(@RequestBody User user);
	public List<User> getAllUsers();
	public Optional<User> getUserById(@PathVariable("id") Long id);
	public void updateUser(@RequestBody User user);
	public void deleteUser(@PathVariable("id") Long id);
	public void deleteAllUsers();
	List<User> findUsersByQualification(@PathVariable("qualification") String qualification);
		 
}
