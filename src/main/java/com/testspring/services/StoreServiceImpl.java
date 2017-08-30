package com.testspring.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.testspring.daos.StoreDAO;
import com.testspring.models.Store;

public class StoreServiceImpl implements StoreService {

	private StoreDAO storeDAO;
	public void setStoreDAO(StoreDAO storeDAO) {
		this.storeDAO = storeDAO;
	}
	
	@Transactional
	public List<Store> getStoreList() {
		return this.storeDAO.getStoreList();
	}

}
