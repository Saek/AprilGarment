package com.testspring.daos;

import java.math.BigDecimal;
import java.util.List;

import com.testspring.models.Cloth;
import com.testspring.models.ajaxResponse.ClothDropDownList;

public interface ClothDAO {
//	public void save(Cloth cloth);
	public List<Cloth> showClothes();
	public List<Cloth> getClothesForDropDownList();
	public List<ClothDropDownList> getClothByStoreId(int storeId);
	public BigDecimal getPriceByClothId(int clothId);
	public Cloth getClothById(int clothId);
	public void updateProductAmountInCloth(int clothId, String factoryName, int produceAmount);
	public void updateAvailableAmountInCloth(int clothId, int sendAmount);
//	public void addCloth(Cloth cloth);
//	public void updateCloth(Cloth cloth);
//	public Cloth getClothById(int id);
//	public void removeCloth(int id);
}
