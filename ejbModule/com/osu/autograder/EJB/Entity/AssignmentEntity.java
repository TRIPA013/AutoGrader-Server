package com.osu.autograder.EJB.Entity;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name = "Assignment")
public class AssignmentEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="AssignmentID")
	private int AssignmentID;
	
	public int getAssignmentID(){
		return this.AssignmentID;
	}
	public void setAssignmentID(int AssignmentID){
		this.AssignmentID = AssignmentID;
	}
	
	@Column(name="AssignmentName")
	private String AssignmentName;
	
	public String getAssignmentName() {
		return AssignmentName;
	}
	public void setAssignmentName(String AssignmentName) {
		this.AssignmentName = AssignmentName;
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
