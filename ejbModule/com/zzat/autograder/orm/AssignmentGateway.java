package com.zzat.autograder.orm;

import com.osu.autograder.EJB.Entity.AssignmentEntity;
import com.osu.autograder.EJB.Entity.CourseEntity;

public class AssignmentGateway {
	public static String insertAssignment(AssignmentEntity assignment) {
		return "Insert into Assignment (CourseID,MaxPoints,AssignmentType,ConfigurationFile,Directory,AssignmentName) values ("
				+ assignment.getCourseID()
				+ ","
				+ assignment.getMaxPoints()
				+ ",'"
				+ assignment.getAssignmentType()
				+ "','"
				+ assignment.getConfigurationFile()
				+ "','"
				+ assignment.getDirectory()
				+ "','"
				+ assignment.getAssignmentName() + "')";

	}

	public static String updateAssignment(AssignmentEntity assignment) {
		return "Update Assignment Set CourseID=" + assignment.getCourseID()
				+ ",MaxPoints=" + assignment.getMaxPoints()
				+ ",AssignmentTyope='" + assignment.getAssignmentType()
				+ "',ConfigurationFile='" + assignment.getConfigurationFile()
				+ "',Directory='" + assignment.getDirectory() + "',AssignmentName='"
				+ assignment.getAssignmentName() + "' where AssignmentID = "
				+ assignment.getAssignmentID();

	}

	public static String deleteAssignment(AssignmentEntity assignment) {
		return "Delete from Assignment where AssignmentID="
				+ assignment.getAssignmentID();

	}

	public static String findAssignmentByAssignmentID(
			AssignmentEntity assignment) {

		return "Select TOP 1 * from Assignment where AssignmentID="
				+ assignment.getAssignmentID();
	}

	public static String findAssignmentByCourseID(CourseEntity course) {

		return "Select * from Assignment where CourseID="
				+ course.getCourseID();
	}
}
