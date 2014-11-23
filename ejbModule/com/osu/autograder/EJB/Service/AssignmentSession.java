package com.osu.autograder.EJB.Service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
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

	public List<AssignmentEntity> findAssignments(CourseEntity course) {

		List<AssignmentEntity> assignments = new ArrayList<AssignmentEntity>();

		Query query = em.createNativeQuery(
				AssignmentGateway.findAssignmentByCourseID(course),
				AssignmentEntity.class);

		assignments = query.getResultList();
		return assignments;
	}
}
