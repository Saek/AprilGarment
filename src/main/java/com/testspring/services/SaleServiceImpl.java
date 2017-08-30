package com.testspring.services;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.testspring.daos.ClothAndStoreDAO;
import com.testspring.daos.ClothDAO;
import com.testspring.daos.SaleDAO;
import com.testspring.daos.StoreDAO;
import com.testspring.models.Cloth;
import com.testspring.models.Sale;
import com.testspring.models.Store;
import com.testspring.models.ajaxRequest.SaleForm;
import com.testspring.models.ajaxResponse.ClothDropDownList;


public class SaleServiceImpl implements SaleService{
	
	private SaleDAO saleDAO;
	private ClothDAO clothDAO;
	private StoreDAO storeDAO;
	private ClothAndStoreDAO clothAndStoreDAO;
	
	public void setSaleDAO(SaleDAO saleDAO) {
		this.saleDAO = saleDAO;
	}
	public void setClothDAO(ClothDAO clothDAO) {
		this.clothDAO = clothDAO;
	}
	public void setStoreDAO(StoreDAO storeDAO) {
		this.storeDAO = storeDAO;
	}
	public void setClothAndStoreDAO(ClothAndStoreDAO clothAndStoreDAO) {
		this.clothAndStoreDAO = clothAndStoreDAO;
	}

	@Transactional
	public List<Sale> getSaleList() {
		return this.saleDAO.getSaleList();
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
	public List<ClothDropDownList> getClothesMap(int storeId) {
		System.out.println("#S getClothList");
		List<ClothDropDownList> clothList = clothDAO.getClothByStoreId(storeId);
		Map<Integer, String> clothDropDownList = new HashMap<Integer, String>();
		return clothList;
	}
	
	@Transactional
	public Cloth getClothInSalePage(int clothId) {
		return this.clothDAO.getClothById(clothId);
	}
	
	@Transactional
	public void sellProducts(SaleForm saleForm) {
		this.saleDAO.insertSale(saleForm);
		this.clothAndStoreDAO.updateAvailableAmountInClothANDStore(saleForm);
	}
}
