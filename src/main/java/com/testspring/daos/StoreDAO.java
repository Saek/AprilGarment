package com.testspring.daos;

import java.util.List;
import java.util.Map;

import com.testspring.models.Store;

public interface StoreDAO {
	public List<Store> getStoreList();
	public List<Store> getStoresForDropDownList();
}
