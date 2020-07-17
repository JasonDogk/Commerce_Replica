package com.user.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserVO {

	@Id
	@Column(name = "id")
	private final String id;
	@Column(name = "name")
	private final String name;
	@Column(name = "surname")
	private final String surname;
	@Column(name = "gender")
	private final String gender;
	@Column(name = "age")
	private final int age;
	@Column(name = "userCategory")
	private final int userCategory;
	@Column(name = "username")
	private final String username;
	
	private UserVO(UserBuilder builder) {
		this.id = builder.id;
        this.name = builder.name;
        this.surname= builder.surname;
        this.gender = builder.gender;
        this.age = builder.age;
        this.userCategory = builder.userCategory;
        this.username = builder.username;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getGender() {
		return gender;
	}
	public int getAge() {
		return age;
	}
	public int getUserCategory() {
		return userCategory;
	}
	public String getUsername() {
		return username;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", gender=" + gender + ", age=" + age
				+ ", userCategory=" + userCategory + ", username=" + username + "]";
	}
	
	public static class UserBuilder{
		
		private final String id;
		private final String name;
		private final String surname;
		private final String gender;
		private final int age;
		private final int userCategory;
		private String username;
		
		public UserBuilder(String name, String surname, String gender, int age, int userCategory) {
			this.id = UUID.randomUUID().toString();
			this.name = name;
			this.surname = surname;
			this.gender = gender;
			this.age = age;
			this.userCategory = userCategory;
		}
		
		public UserBuilder username(String username) {
			this.username = username;
			return this;
		}
		
		public UserVO build() {
			UserVO user = new UserVO(this);
			validateUserObject(user);
			return user;
		}
		
		private void validateUserObject(UserVO user) {
			
			
		}
	}
	
	
	
	
}