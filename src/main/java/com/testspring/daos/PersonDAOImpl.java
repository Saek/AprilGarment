package com.testspring.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.testspring.models.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Person> getPeople() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> people = session.createQuery("from Person").list();
		return people;
	}

}
