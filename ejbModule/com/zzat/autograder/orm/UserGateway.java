package com.zzat.autograder.orm;

import com.osu.autograder.EJB.Entity.UserEntity;

public class UserGateway {

	public static String inserUser(UserEntity user) {
		return  "Insert into User (UserName,Password,EmailAdd,Role,Name) values ('"
				+ user.getUserName()
				+ "','"
				+ user.getPassword()
				+ "','"
				+ user.getEmailAdd()
				+ "','"
				+ user.getRole()
				+ "','"
				+ user.getName() + "')";
		
	}

	public static String updateUser(UserEntity user) {
		return  "Update User Set UserName=" + user.getUserName()
				+ ",Password='" + user.getPassword() + "',EmailAdd='"
				+ user.getEmailAdd() + "',Role='" + user.getRole()
				+ "',Name='" + user.getName() + "' where UserID = "
				+ user.getUserID();
		
	}

	public static String  deleteUser(UserEntity user) {
		return "Delete from User where UserID=" + user.getUserID();
		
	}

	public static String findUserByUserID(UserEntity user) {

		return "Select TOP 1 * from User where UserID="
				+ user.getUserID();

	}
	
	public static String login(UserEntity user) {

		return "Select TOP 1 * from User where UserName='"
				+ user.getUserName()+"' and Password='"+ user.getPassword()+"' and Role='" + user.getRole()+"'";

	}
}
