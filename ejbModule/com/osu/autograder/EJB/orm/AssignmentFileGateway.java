package com.osu.autograder.EJB.orm;

import com.osu.autograder.EJB.Entity.AssignmentFileEntity;

public class AssignmentFileGateway {

	public static String insertAssignmentFile(
			AssignmentFileEntity assignmentFile) {
		return "Insert into AssignmentFile (AssignmentFileName,AssignmentID,UserID,Score,IsSolution) values ('"
				+ assignmentFile.getAssignmentFileName()
				+ "','"
				+ assignmentFile.getAssignmentID()
				+ "','"
				+ assignmentFile.getUserID()
				+ "','"
				+ assignmentFile.getScore()
				+ "','"
				+ assignmentFile.getIsSolution() + "')";

	}

	public static String updateAssignmentFile(
			AssignmentFileEntity assignmentFile) {
		return "Update AssignmentFile Set AssignmentID="
				+ assignmentFile.getAssignmentID() + ",AssignmentFileName='"
				+ assignmentFile.getAssignmentFileName() + "',Score='"
				+ assignmentFile.getScore() + "',IsSolution="
				+ assignmentFile.getIsSolution() + " where AssignmentFileID = "
				+ assignmentFile.getAssignmentFileID();

	}

	public static String deleteAssignmentFile(
			AssignmentFileEntity assignmentFile) {
		return "Delete from AssignmentFile where AssignmentFileID="
				+ assignmentFile.getAssignmentFileID();

	}

	public static String findAssignmentFileByAssignmentFileID(
			AssignmentFileEntity assignmentFile) {

		return "Select TOP 1 * from AssignmentFile where AssignmentFileID="
				+ assignmentFile.getAssignmentFileID();
	}

	public static String findAssignmentFileByAssignmentID(
			AssignmentFileEntity assignmentFile) {

		return "Select TOP 1 * from AssignmentFile where AssignmentID="
				+ assignmentFile.getAssignmentID();

	}

	public static String findAssignmentFileByUserAssignmentID(
			AssignmentFileEntity assignmentFile) {

		return "Select TOP 1 * from AssignmentFile where userID="
				+ assignmentFile.getUserID() + " and assignmentID="
				+ assignmentFile.getAssignmentID();

	}

}
