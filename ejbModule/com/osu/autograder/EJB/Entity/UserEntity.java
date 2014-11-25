package com.osu.autograder.EJB.Entity;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name = "User")
public class UserEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="UserID")
	private String userID;
	
	public String getUserID(){
		return this.userID;
	}
	public void setuserID(String userID){
		this.userID = userID;
	}
	
	
	@Column(name="UserName")
	private String UserName;
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	


	@Column(name="Password")
	private String Password;


	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}


	@Column(name="EmailAdd")
	private String EmailAdd;
	
	
	public String getEmailAdd() {
		return EmailAdd;
	}
	public void setEmailAdd(String EmailAdd) {
		this.EmailAdd = EmailAdd;
	}


	@Column(name="Role")
	private char Role;
	
	public char getRole() {
		return Role;
	}
	public void setRole(char Role) {
		this.Role = Role;
	}
	
	@Column(name="Name")
	private String Name;
	
	
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}

	
}
