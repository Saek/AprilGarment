package com.testspring.daos;

import java.util.List;

import com.testspring.models.Sale;
import com.testspring.models.ajaxRequest.SaleForm;

public interface SaleDAO {
	public Sale getSaleById(int saleId);
	public List<Sale> getSaleList();
	public void insertSale(SaleForm saleForm);
}
