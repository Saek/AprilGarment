package com.testspring.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cloth_store")
public class ClothAndStore {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cloth_store_id")
	private int clothAndStoreId;
	@Column(name="cloth_id")
	private int clothId;
	@Column(name="store_id")
	private int storeId;
	@Column(name="amount")
	private int amount;
	@Column(name="updated_by")
	private String updatedBy;
	@Column(name="updated_date")
	private Date updatedDate;
	@Column(name="available_amount")
	private int availableAmount;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cloth_id", insertable=false, updatable=false)
	private Cloth cloth;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="store_id", insertable=false, updatable=false)
	private Store store;
	
	public Cloth getCloth() {
		return cloth;
	}
	public void setCloth(Cloth cloth) {
		this.cloth = cloth;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public int getAvailableAmount() {
		return availableAmount;
	}
	public void setAvailableAmount(int availableAmount) {
		this.availableAmount = availableAmount;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getClothAndStoreId() {
		return clothAndStoreId;
	}
	public void setClothAndStoreId(int clothAndStoreId) {
		this.clothAndStoreId = clothAndStoreId;
	}
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
	
	@Override
	public String toString() {
		return "ClothAndStore [clothAndStoreId=" + clothAndStoreId + ", clothId=" + clothId + ", storeId=" + storeId
				+ ", amount=" + amount + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", availableAmount=" + availableAmount + ", cloth=" + cloth + ", store=" + store + "]";
	}
}
