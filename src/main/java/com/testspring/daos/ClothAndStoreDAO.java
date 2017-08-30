package com.testspring.daos;

import com.testspring.models.ajaxRequest.SaleForm;

public interface ClothAndStoreDAO {
	public void saveOrUpdate(int clothId, int storeId, int amount);
	public void updateAvailableAmountInClothANDStore(SaleForm saleForm);
}
