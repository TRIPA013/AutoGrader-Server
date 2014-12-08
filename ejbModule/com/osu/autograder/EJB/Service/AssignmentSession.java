package com.osu.autograder.EJB.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.osu.autograder.EJB.Entity.AssignmentEntity;
import com.osu.autograder.EJB.Entity.CourseEntity;
import com.zzat.autograder.orm.AssignmentGateway;

@Stateless
public class AssignmentSession {
	@PersistenceContext(unitName = "examples-769-EJB")
	EntityManager em;

	private static final String UPLOADS_MAIN_FOLDER = "D:////uploads";

	public List<AssignmentEntity> findAssignments(CourseEntity course) {

		List<AssignmentEntity> assignments = new ArrayList<AssignmentEntity>();

		Query query = em.createNativeQuery(
				AssignmentGateway.findAssignmentByCourseID(course),
				AssignmentEntity.class);

		assignments = query.getResultList();
		return assignments;
	}

	public void grade(CourseEntity courseEntity,
			AssignmentEntity assignmentEntity) {
		String assignmentID = assignmentEntity.getAssignmentID() + "";
		String courseID = assignmentEntity.getCourseID();
		File folder = new File(UPLOADS_MAIN_FOLDER + "\\Course" + courseID
				+ "\\Assignment" + assignmentID);
		File[] listFiles = folder.listFiles();
		for (File file : listFiles) {
			if (file.isDirectory()) {
				System.out.println("Directory: " + file.getName());
				
			} else {
			}
		}
	}

	public boolean addAssignment(AssignmentEntity assignment) {

		try {
			em.persist(assignment);
			em.flush();
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public boolean updateAssignment(AssignmentEntity assignment) {

		Query query = em.createNativeQuery(
				AssignmentGateway.insertAssignment(assignment),
				AssignmentEntity.class);

		try {
			query.executeUpdate();
			em.flush();

		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public boolean addAssignment(String assignmentName, String assignmentType,
			String configFile, String maxPoints, String directory,
			String courseID) {

		AssignmentEntity newEntity = new AssignmentEntity();

		newEntity.setAssignmentName(assignmentName);
		newEntity.setAssignmentType(assignmentType);
		newEntity.setDirectory(directory);
		newEntity.setConfigurationFile(configFile);
		newEntity.setMaxPoints(maxPoints);
		newEntity.setCourseID(courseID);

		try {
			em.persist(newEntity);
			em.flush();
		} catch (Exception e) {
			return false;
		}

		return true;
	}

}
