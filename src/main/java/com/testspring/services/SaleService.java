package com.testspring.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.testspring.models.Cloth;
import com.testspring.models.Sale;
import com.testspring.models.ajaxRequest.SaleForm;
import com.testspring.models.ajaxResponse.ClothDropDownList;

public interface SaleService {
	public List<Sale> getSaleList();
	public Map<Integer, String> getStoresMap();
	public List<ClothDropDownList> getClothesMap(int storeId);
	public Cloth getClothInSalePage(int clothId);
	public void sellProducts(SaleForm saleForm);
}
