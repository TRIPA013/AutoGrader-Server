package com.osu.autograder.EJB.Entity;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name = "Assignment")
public class AssignmentEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="AssignmentID")
	private String AssignmentID;
	
	public String getAssignmentID(){
		return this.AssignmentID;
	}
	public void setAssignmentID(String AssignmentID){
		this.AssignmentID = AssignmentID;
	}
	
	
	@Column(name="CourseID")
	private String CourseID;
	
	public String getCourseID() {
		return CourseID;
	}
	public void setCourseID(String CourseID) {
		this.CourseID = CourseID;
	}

	@Column(name="MaxPoints")
	private String MaxPoints;
	
	public String getMaxPoints() {
		return MaxPoints;
	}
	public void setMaxPoints(String maxPoints) {
		MaxPoints = maxPoints;
	}
	
	
	@Column(name="AssignmentType")
	private String AssignmentType;
	
	public String getAssignmentType() {
		return AssignmentType;
	}
	
	public void setAssignmentType(String assignmentType) {
		AssignmentType = assignmentType;
	}
	
	@Column(name="ConfigurationFile")
	private String ConfigurationFile;
	
	public String getConfigurationFile() {
		return ConfigurationFile;
	}
	
	public void setConfigurationFile(String configurationFile) {
		ConfigurationFile = configurationFile;
	}
	
	@Column(name="Directory")
	private String Directory;

	public String getDirectory() {
		return Directory;
	}
	
	public void setDirectory(String directory) {
		Directory = directory;
	}
}
