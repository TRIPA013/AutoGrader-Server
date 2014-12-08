package com.osu.autograder.EJB.Entity;
import java.io.*;

import javax.persistence.*;

@Entity
@Table(name = "Seat")
public class SeatEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="SeatID")
	private String SeatID;
	
	public String getSeatID(){
		return this.SeatID;
	}
	public void setSeatID(String SeatID){
		this.SeatID = SeatID;
	}
	
	
	@Column(name="CourseID")
	private String CourseID;
	
	public String getCourseID() {
		return CourseID;
	}
	public void setCourseID(String CourseID) {
		this.CourseID = CourseID;
	}

	@Column(name="UserID")
	private String UserID;
	
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String UserID) {
		this.UserID = UserID;
	}


	
}
