package com.somosbooking.somosBack.model;

import javax.persistence.*;


@Entity
@Table(name = "user")
public class User {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid", unique = true, nullable = false)
	private int userId;
	@Column(name="username")
	private String userName;
	@Column(name="usermail")
	private String userMail;
	@Column(name="userpassword")
	private String userPassword;
	@Column(name="userphone")
	private String userPhone;
	
	@Column(name="usertype",  columnDefinition  = "ENUM('Administrador', 'Banda', 'Normal')'")
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	
	public User(int userId, String userName, String userMail, String userPassword, String userPhone, UserType userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userMail = userMail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userType = userType;


	}
	
	public User() {
		super();
	}


	public int getUserId() {
		return userId;
	}


	public void setId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserMail() {
		return userMail;
	}


	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


	public UserType getUserType() {
		return userType;
	}


	public void setUserType(UserType userType) {
		this.userType = userType;
	}


	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", userName='" + userName + '\'' +
				", userMail='" + userMail + '\'' +
				", userPassword='" + userPassword + '\'' +
				", userPhone='" + userPhone + '\'' +
				", userType=" + userType +
				'}';
	}
}
