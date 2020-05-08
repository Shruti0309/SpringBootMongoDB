package com.mongoDB.connector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongoDB.connector.dao.UserDao;
import com.mongoDB.connector.model.User;

/*Add the following code to the service Impl class where we will 
 * implement the methods of the Dao interface to handle the sql operations.*/


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public void createUser(User user) {
		userDao.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userDao.findAll();
	}

	@Override
	public Optional<User> getUserById(Long id) {
		
		return userDao.findById(id);
	}

	@Override
	public void updateUser(User user) {
		
		userDao.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		
		userDao.deleteById(id);
	}

	@Override
	public void deleteAllUsers() {
		userDao.deleteAll();
		
	}

	@Override
	public List<User> findUsersByQualification(String qualification) {
		return userDao.findUsersByQualification(qualification);
	}

}
