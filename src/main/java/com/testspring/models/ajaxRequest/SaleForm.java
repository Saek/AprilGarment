package com.testspring.models.ajaxRequest;

import java.math.BigDecimal;

import com.testspring.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class SaleForm {
	
	@JsonView(Views.Public.class)
	private int storeId;
	@JsonView(Views.Public.class)
	private int clothId;
	@JsonView(Views.Public.class)
	private int saleAmount;
	@JsonView(Views.Public.class)
	private BigDecimal pricePerOne;
	@JsonView(Views.Public.class)
	private BigDecimal totalSale;
	
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getClothId() {
		return clothId;
	}
	public void setClothId(int clothId) {
		this.clothId = clothId;
	}
	public int getSaleAmount() {
		return saleAmount;
	}
	public void setSaleAmount(int saleAmount) {
		this.saleAmount = saleAmount;
	}
	public BigDecimal getPricePerOne() {
		return pricePerOne;
	}
	public void setPricePerOne(BigDecimal pricePerOne) {
		this.pricePerOne = pricePerOne;
	}
	public BigDecimal getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(BigDecimal totalSale) {
		this.totalSale = totalSale;
	}
	
//	storeId: $('#storesDDL').val(),
//	clothModel: $('#clothesDDL').val(),
//	saleAmount: $('#amount').val(),
//	pricePerOne: pricePerOne,
//	totalSale: totalSale

}
