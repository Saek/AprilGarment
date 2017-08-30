package com.testspring.services;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testspring.daos.ClothAndStoreDAO;
import com.testspring.daos.ClothDAO;
import com.testspring.daos.FactoryDAO;
import com.testspring.daos.StoreDAO;
import com.testspring.models.Cloth;
import com.testspring.models.Factory;
import com.testspring.models.Store;
import com.testspring.models.ajaxRequest.ProductForm;

@Service
public class ProductServiceImpl implements ProductService {

	private FactoryDAO factoryDAO;
	private ClothDAO clothDAO;
	private StoreDAO storeDAO;
	private ClothAndStoreDAO clothAndStoreDAO;
	
	public void setClothAndStoreDAO(ClothAndStoreDAO clothAndStoreDAO) {
		this.clothAndStoreDAO = clothAndStoreDAO;
	}
	
	public void setFactoryDAO(FactoryDAO factoryDAO) {
		this.factoryDAO = factoryDAO;
	}
	
	public void setClothDAO(ClothDAO clothDAO) {
		this.clothDAO = clothDAO;
	}
	
	public void setStoreDAO(StoreDAO storeDAO) {
		this.storeDAO = storeDAO;
	}
	
	@Transactional
	public Map<Integer, String> getFactoriesMap() {
		System.out.println("#S getFactoryList() in ProductServiceImpl");
		List<Factory> factoryList = factoryDAO.getFactoriesForDropDownList();
		
		Map<Integer, String> factoryDropDownList = new HashMap<Integer, String>();
		for(Object obj : factoryList) {
			Object[] objs = (Object[]) obj;
			Integer factoryId = (Integer) objs[0];
			String factoryName = (String) objs[1];
			System.out.println("#S factory.getFactoryId(): " + factoryId);
			System.out.println("#S factory.getFactoryName(): " + factoryName);
			factoryDropDownList.put(factoryId, factoryName);
		}
		System.out.println("#S factoryDropDownList: " + factoryDropDownList);
		return factoryDropDownList;
	}
	
	@Transactional
	public Map<Integer, String> getClothesMap() {
		System.out.println("#S getClothList");
		List<Cloth> clothList = clothDAO.getClothesForDropDownList();
		
		Map<Integer, String> clothDropDownList = new HashMap<Integer, String>();
		for(Object obj : clothList) {
			Object[] objs = (Object[]) obj;
			Integer clothId = (Integer) objs[0];
			String model = (String) objs[1];
			System.out.println("#S clothId(): " + clothId);
			System.out.println("#S model: " + model);
			clothDropDownList.put(clothId, model);
		}
		System.out.println("#S compDropDownList: " + clothDropDownList);
		return clothDropDownList;
	}

	@Transactional
	public Map<Integer, String> getStoresMap() {
		System.out.println("#S getStoresMap");
		List<Store> storeList = storeDAO.getStoresForDropDownList();
		
		Map<Integer, String> storeDropDownList = new HashMap<Integer, String>();
		for(Object obj : storeList) {
			Object[] objs = (Object[]) obj;
			Integer storeId = (Integer) objs[0];
			String storeName = (String) objs[1];
			System.out.println("#S clothId(): " + storeId);
			System.out.println("#S model: " + storeName);
			storeDropDownList.put(storeId, storeName);
		}
		System.out.println("#S storeDropDownList: " + storeDropDownList);
		return storeDropDownList;
	}
	
	@Transactional
	public BigDecimal getPriceByClothId(int clothId) {
		return this.clothDAO.getPriceByClothId(clothId);
	}

	@Transactional
	public void addProduct(ProductForm productForm) {
		System.out.println("#S addProduct");
		Factory factory = this.factoryDAO.getFactoryById(productForm.getFactoryId());
		String factoryName = factory.getFactoryName();
		this.clothDAO.updateProductAmountInCloth(productForm.getClothId(), factoryName, productForm.getProductAmount());
		
	}

	@Transactional
	public Cloth getClothInSendProductPage(int clothId) {
		return this.clothDAO.getClothById(clothId);
		
	}

	@Transactional
	public void saveClothAndStore(int clothId, int storeId, int amount) {
		System.out.println("#S saveClothAndStore");
		this.clothAndStoreDAO.saveOrUpdate(clothId, storeId, amount);
		this.clothDAO.updateAvailableAmountInCloth(clothId, amount);
	}
}
