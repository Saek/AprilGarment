package com.testspring.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Cloth")
public class Cloth {
	
	@Id
	@Column(name="cloth_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int clothId;
	
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="model")
	private String model;
	
	@Column(name="color")
	private String color;
	
	@Column(name="size")
	private String size;
	
	@Column(name="active")
	private String active;
	
	@Column(name="made_by_year")
	private Date madeByYear;
	
	@Column(name="cloth_type")
	private String clothType;
	
	@Column(name="cloth_group")
	private String clothGroup;
	
	@Column(name="cloth_brand")
	private String clothBrand;
	
	@Column(name="produce_amount")
	private int produceAmount;
	
	@Column(name="factory_name")
	private String factoryName;
	
	@Column(name="available_amount")
	private int availableAmount;
	
	@Column(name="store")
	private String store;
	
	@OneToMany(mappedBy="cloth")
	private Set<ClothAndStore> clothAndStore = new HashSet<ClothAndStore>();
	
	public Set<ClothAndStore> getClothAndStore() {
		return clothAndStore;
	}
	public void setClothAndStore(Set<ClothAndStore> clothAndStore) {
		this.clothAndStore = clothAndStore;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public int getAvailableAmount() {
		return availableAmount;
	}
	public void setAvailableAmount(int availableAmount) {
		this.availableAmount = availableAmount;
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	public int getProduceAmount() {
		return produceAmount;
	}
	public void setProduceAmount(int produceAmount) {
		this.produceAmount = produceAmount;
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
	
	@Override
	public String toString() {
		return "Cloth [clothId=" + clothId + ", price=" + price + ", model=" + model + ", color=" + color + ", size="
				+ size + ", active=" + active + ", madeByYear=" + madeByYear + ", clothType=" + clothType
				+ ", clothGroup=" + clothGroup + ", clothBrand=" + clothBrand + ", produceAmount=" + produceAmount
				+ ", factoryName=" + factoryName + ", availableAmount=" + availableAmount + "]";
	}
		
}
