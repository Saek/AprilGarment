package com.testspring.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testspring.daos.PersonDAO;
import com.testspring.models.Person;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonDAO personDAO;
	
	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	@Transactional
	public List<Person> getPeople() {
		return personDAO.getPeople();
	}

}
