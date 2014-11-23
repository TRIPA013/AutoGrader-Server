package com.osu.autograder.EJB.Entity;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name = "Course")
public class CourseEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CourseID")
	private String CourseID;
	
	public String getCourseID(){
		return this.CourseID;
	}
	public void setCourseID(String CourseID){
		this.CourseID = CourseID;
	}
	
	
	@Column(name="CourseName")
	private String CourseName;
	
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String CourseName) {
		this.CourseName = CourseName;
	}

	
}
