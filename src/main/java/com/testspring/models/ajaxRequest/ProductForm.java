package com.testspring.models.ajaxRequest;

import com.testspring.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class ProductForm {
	
	@JsonView(Views.Public.class)
	private int factoryId;
	@JsonView(Views.Public.class)
	private int clothId;
	@JsonView(Views.Public.class)
	private int productAmount;
	
	public int getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(int factoryId) {
		this.factoryId = factoryId;
	}
	public int getClothId() {
		return clothId;
	}
	public void setClothId(int clothId) {
		this.clothId = clothId;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
}
