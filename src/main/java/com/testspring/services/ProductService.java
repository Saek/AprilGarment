package com.testspring.services;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.testspring.models.Cloth;
import com.testspring.models.ajaxRequest.ProductForm;

public interface ProductService {
	public Map<Integer, String> getFactoriesMap();
	public Map<Integer, String> getClothesMap();
	public Map<Integer, String> getStoresMap();
	public BigDecimal getPriceByClothId(int clothId);
	public void addProduct(ProductForm productForm);
	public Cloth getClothInSendProductPage(int clothId);
	public void saveClothAndStore(int clothId, int storeId, int amount);
}
