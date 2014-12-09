package com.osu.autograder.EJB.Entity;
import java.io.*;

import javax.persistence.*;

@Entity
@Table(name = "AssignmentFile")
public class AssignmentFileEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="AssignmentFileID")
	private int AssignmentFileID;
	public int getAssignmentFileID() {
		return AssignmentFileID;
	}

	public void setAssignmentFileID(int assignmentFileID) {
		AssignmentFileID = assignmentFileID;
	}
	
	@Column(name="AssignmentID")
	private String AssignmentID;

	public String getAssignmentID() {
		return AssignmentID;
	}

	public void setAssignmentID(String assignmentID) {
		AssignmentID = assignmentID;
	}
	
	@Column(name="UserID")
	private String UserID;

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}
	
	@Column(name="AssignmentFileName")
	private String AssignmentFileName;

	public String getAssignmentFileName() {
		return AssignmentFileName;
	}

	public void setAssignmentFileName(String assignmentFileName) {
		AssignmentFileName = assignmentFileName;
	}
	
	@Column(name="Score")
	private String Score;
	

	public String getScore() {
		return Score;
	}

	public void setScore(String score) {
		Score = score;
	}

	@Column(name="IsSolution")
	private String IsSolution;

	public String getIsSolution() {
		return IsSolution;
	}

	public void setIsSolution(String isSolution) {
		IsSolution = isSolution;
	}

	
}
