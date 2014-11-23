package com.osu.autograder.EJB.Service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.osu.autograder.EJB.Entity.CourseEntity;
import com.osu.autograder.EJB.Entity.UserEntity;
import com.zzat.autograder.orm.CourseGateway;

@Stateless
public class CourseSession {
	@PersistenceContext(unitName = "examples-769-EJB")
	EntityManager em;

	public List<CourseEntity> findCourses(UserEntity user) {
		
		List<CourseEntity> courses = new ArrayList<CourseEntity>();

		Query query = em.createNativeQuery
				(CourseGateway.findCourseByUserID(user), CourseEntity.class);

		courses = query.getResultList();
		return courses;
	}
}
