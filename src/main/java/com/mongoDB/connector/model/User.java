package com.mongoDB.connector.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/* User collection(table) in mongoDB and User entity(defined below) should have exact same attributes 
 * The primary key _id is automatically added if _id field is not specified.
 * The MongoDB examples assume a collection named User that contain documents of the following prototype
 *  {
	  	_id: ObjectId("509a8fb2f3f4948bd2f983a0"),
	  	age: 55,
	  	name: "Shruti",
	  	qualification: "Master's" 
	  	residentCountry: "Australia"
}
MongoDb stores each record in form of document
*/

@Document(collection= "User")
public class User {

	@Id
	private Long _id;
	private int age;
	private String name;
	private String qualification;
	private String residentCountry;
	
	
	public User() {}


	public User(int age, String name, String qualification, String residentCountry) {
		super();
		this.age = age;
		this.name = name;
		this.qualification = qualification;
		this.residentCountry = residentCountry;
	}


	public Long getId() {
		return _id;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public String getResidentCountry() {
		return residentCountry;
	}


	public void setResidentCountry(String residentCountry) {
		this.residentCountry = residentCountry;
	}


	@Override
	public String toString() {
		return "User [id=" + _id + ", age=" + age + ", name=" + name + ", qualification=" + qualification
				+ ", residentCountry=" + residentCountry + "]";
	}

}
