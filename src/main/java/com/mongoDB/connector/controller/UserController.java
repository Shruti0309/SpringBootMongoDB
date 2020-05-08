package com.mongoDB.connector.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongoDB.connector.model.User;
import com.mongoDB.connector.service.UserService;

/*We create a controller that provides APIs for creating, retrieving, updating, deleting and finding User details.*/



@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/*
	 * We use @PostMapping annotation for handling POST HTTP requests. A new
	 * User will be created by MongoRepository.save() method.
	 */

	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		try {
			userService.createUser(user);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}

	/*
	 * We use @GetMapping annotation for handling GET HTTP requests, then
	 * Repository’s getAllUsers(), getUserById(id), findUsersByQualification(qualification)
	 * method to get the result.
	 */

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			List<User> users = userService.getAllUsers();

			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		Optional<User> userData = userService.getUserById(id);
		if (userData.isPresent()) {
			return new ResponseEntity<>(userData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/usersByQualification/{qualification}")
	public ResponseEntity<List<User>> getUsersByQualification(@PathVariable("qualification") String qualification) {
		try {
			List<User> users = userService.findUsersByQualification(qualification);
			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	/*
	 * @PutMapping will help us handle PUT HTTP requests. – updateUser()
	 * receives id and a user payload. – from the id, we get the user from
	 * database using findById() method. – then we use the payload and save() method
	 * for updating the user.
	 */
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		Optional<User> userData = userService.getUserById(id);
		if (userData.isPresent()) {

			userService.createUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 * We use @DeleteMapping for DELETE HTTP requests. There are 2 methods:
	 * 
	 * deleteUser(): delete a User document with given id
	 * deleteAllUsers(): remove all documents in User collection The
	 * operations is done with the help of MongoRepository’s deleteById() and
	 * deleteAll() method.
	 */

	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
		try {
			userService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@DeleteMapping("/users")
	public ResponseEntity<HttpStatus> deleteAllUsers() {
		try {
			userService.deleteAllUsers();	 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}
