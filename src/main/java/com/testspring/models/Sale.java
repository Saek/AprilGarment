package com.testspring.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sale")
public class Sale {
	
	@Id
	@Column(name="sale_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int saleId;
	@Column(name="store_id")
	private int storeId;
	@Column(name="cloth_id")
	private int clothId;
	@Column(name="sale_amounts")
	private int saleAmounts;
	@Column(name="total_sale")
	private BigDecimal totalSale;
	@Column(name="sale_date_time")
	private Date saleDateTime;
	
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
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
	public int getSaleAmounts() {
		return saleAmounts;
	}
	public void setSaleAmounts(int saleAmounts) {
		this.saleAmounts = saleAmounts;
	}
	public BigDecimal getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(BigDecimal totalSale) {
		this.totalSale = totalSale;
	}
	public Date getSaleDateTime() {
		return saleDateTime;
	}
	public void setSaleDateTime(Date saleDateTime) {
		this.saleDateTime = saleDateTime;
	}
	
	@Override
	public String toString() {
		return "Sale [saleId=" + saleId + ", storeId=" + storeId + ", clothId=" + clothId + ", saleAmounts="
				+ saleAmounts + ", totalSale=" + totalSale + ", saleDateTime=" + saleDateTime + "]";
	}
	
}
