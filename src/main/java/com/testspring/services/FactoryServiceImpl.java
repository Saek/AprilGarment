package com.testspring.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testspring.daos.FactoryDAO;
import com.testspring.models.Factory;

@Service
public class FactoryServiceImpl implements FactoryService {

	private FactoryDAO factoryDAO;
	
	public void setFactoryDAO(FactoryDAO factoryDAO) {
		this.factoryDAO = factoryDAO;
	}
	
	@Transactional
	public List<Factory> showFactories() {
		return this.factoryDAO.showFactories();
	}

}
