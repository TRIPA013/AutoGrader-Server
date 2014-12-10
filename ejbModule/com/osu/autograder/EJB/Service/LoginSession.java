package com.osu.autograder.EJB.Service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.osu.autograder.EJB.Entity.CourseEntity;
import com.osu.autograder.EJB.Entity.UserEntity;
import com.osu.autograder.EJB.orm.CourseGateway;
import com.osu.autograder.EJB.orm.UserGateway;

@Stateless
public class LoginSession {
	@PersistenceContext(unitName = "examples-769-EJB")
	EntityManager em;

	public UserEntity login(UserEntity user) { // method called from LoginBean
												// Backing Bean

		UserEntity newEntity = user;

		List<UserEntity> users = new ArrayList<UserEntity>();

		try {
			Query query = em.createNativeQuery // create query using this syntax
					(UserGateway.login(user), UserEntity.class);

			users = query.getResultList();

			if (!users.isEmpty()) // if user actually exists
			{
				newEntity = users.get(0);
				return newEntity;
			}
		}

		catch (Exception e) {
			return newEntity;
		}

		return newEntity; // return fail if user not found and handle
							// appropriately
		// in Backing Bean
	}

	public List<UserEntity> findEmails(String courseID) {

		List<UserEntity> users = new ArrayList<UserEntity>();
		try {
			String querystring = "select * from User u inner join Seat s on u.UserID = s.UserID where s.CourseID= "
					+ courseID + " and Role='S'";
			Query query = em.createNativeQuery(querystring, UserEntity.class);

			users = query.getResultList();
		}

		catch (Exception e) {
			return users;
		}

		return users;
	}

}
