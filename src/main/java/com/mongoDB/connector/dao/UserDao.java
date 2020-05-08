package com.mongoDB.connector.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongoDB.connector.model.User;


/*  Dao interface that extends the Mongo Repository to automatically handle the crud queries.
 * Now we can use MongoRepository’s methods: save(), findOne(), findById(), 
 * findAll(), count(), delete(), deleteById()… without implementing these methods.
 * We can also define our own custom methods
 * - findUsersByQualification(): returns List of users with given qualification*/

@Repository
public interface UserDao extends MongoRepository<User, Long>{

	List<User> findUsersByQualification(String qualification);
}
