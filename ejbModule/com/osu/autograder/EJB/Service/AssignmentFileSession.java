package com.osu.autograder.EJB.Service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.osu.autograder.EJB.Entity.AssignmentEntity;
import com.osu.autograder.EJB.Entity.AssignmentFileEntity;
import com.osu.autograder.EJB.Entity.CourseEntity;
import com.zzat.autograder.orm.AssignmentFileGateway;
import com.zzat.autograder.orm.AssignmentGateway;

@Stateless
public class AssignmentFileSession {
	@PersistenceContext(unitName = "examples-769-EJB")
	EntityManager em;

	public List<AssignmentFileEntity> findAssignmentFiles(
			AssignmentFileEntity assignmentFile) {

		List<AssignmentFileEntity> assignmentFiles = new ArrayList<AssignmentFileEntity>();

		Query query = em.createNativeQuery(AssignmentFileGateway
				.findAssignmentFileByAssignmentFileID(assignmentFile),
				AssignmentEntity.class);

		assignmentFiles = query.getResultList();
		return assignmentFiles;
	}

	public boolean addAssignment(AssignmentFileEntity assignmentFile) {

		try {
			em.persist(assignmentFile);
			em.flush();
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public boolean updateAssignment(AssignmentFileEntity assignmentFile) {

		Query query = em.createNativeQuery(
				AssignmentFileGateway.insertAssignmentFile(assignmentFile),
				AssignmentFileEntity.class);

		try {
			query.executeUpdate();
			em.flush();

		} catch (Exception e) {
			return false;
		}

		return true;
	}
}
