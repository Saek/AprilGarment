package com.testspring.models.ajaxRequest;

import com.testspring.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class SendProductForm {
	
	@JsonView(Views.Public.class)
	private int clothId;
	@JsonView(Views.Public.class)
	private int storeId;
	@JsonView(Views.Public.class)
	private int sendAmount;
	
	public int getClothId() {
		return clothId;
	}
	public void setClothId(int clothId) {
		this.clothId = clothId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getSendAmount() {
		return sendAmount;
	}
	public void setSendAmount(int sendAmount) {
		this.sendAmount = sendAmount;
	}
	
	
}
