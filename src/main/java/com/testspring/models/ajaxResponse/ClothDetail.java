package com.testspring.models.ajaxResponse;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.testspring.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class ClothDetail {
	
	@JsonView(Views.Public.class)
	private int clothId;
	@JsonView(Views.Public.class)
	private BigDecimal price;
	@JsonView(Views.Public.class)
	private String model;
	@JsonView(Views.Public.class)
	private String color;
	@JsonView(Views.Public.class)
	private String size;
	@JsonView(Views.Public.class)
	private String active;
	@JsonView(Views.Public.class)
	private Date madeByYear;
	@JsonView(Views.Public.class)
	private String clothType;
	@JsonView(Views.Public.class)
	private String clothGroup;
	@JsonView(Views.Public.class)
	private String clothBrand;
	@JsonView(Views.Public.class)
	private int availableAmount;
	
	public int getAvailableAmount() {
		return availableAmount;
	}
	public void setAvailableAmount(int availableAmount) {
		this.availableAmount = availableAmount;
	}
	public String getClothBrand() {
		return clothBrand;
	}
	public void setClothBrand(String clothBrand) {
		this.clothBrand = clothBrand;
	}
	public String getClothGroup() {
		return clothGroup;
	}
	public void setClothGroup(String clothGroup) {
		this.clothGroup = clothGroup;
	}
	public String getClothType() {
		return clothType;
	}
	public void setClothType(String clothType) {
		this.clothType = clothType;
	}
	public int getClothId() {
		return clothId;
	}
	public void setClothId(int clothId) {
		this.clothId = clothId;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public Date getMadeByYear() {
		return madeByYear;
	}
	public void setMadeByYear(Date madeByYear) {
		this.madeByYear = madeByYear;
	}
}
