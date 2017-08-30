package com.testspring.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="factory")
public class Factory {
	
	@Id
	@Column(name="factory_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int factoryId;
	
	@Column(name="factory_name")
	private String factoryName;
	
	@Column(name="house_no_addr")
	private String houseNo;
	
	@Column(name="village_no_addr")
	private String villageNo;
	
	@Column(name="alley_addr")
	private String alley;
	
	@Column(name="lane_addr")
	private String lane;
	
	@Column(name="road_addr")
	private String road;
	
	@Column(name="sub_district_addr")
	private String subDistrict;
	
	@Column(name="district_addr")
	private String District;
	
	@Column(name="province_addr")
	private String province;
	
	@Column(name="postal_code_addr")
	private String postalCode;
	
	@Column(name="country_addr")
	private String country;
	
	@Column(name="founded_date")
	private Date foundedDate;
	
	@Column(name="ceo")
	private String ceo;
	
	public int getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(int factoryId) {
		this.factoryId = factoryId;
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getVillageNo() {
		return villageNo;
	}
	public void setVillageNo(String villageNo) {
		this.villageNo = villageNo;
	}
	public String getAlley() {
		return alley;
	}
	public void setAlley(String alley) {
		this.alley = alley;
	}
	public String getLane() {
		return lane;
	}
	public void setLane(String lane) {
		this.lane = lane;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public String getSubDistrict() {
		return subDistrict;
	}
	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getFoundedDate() {
		return foundedDate;
	}
	public void setFoundedDate(Date foundedDate) {
		this.foundedDate = foundedDate;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	
	@Override
	public String toString() {
		return "Factory [factoryId=" + factoryId + ", factoryName=" + factoryName + ", houseNo=" + houseNo
				+ ", villageNo=" + villageNo + ", alley=" + alley + ", lane=" + lane + ", road=" + road
				+ ", subDistrict=" + subDistrict + ", District=" + District + ", province=" + province + ", postalCode="
				+ postalCode + ", country=" + country + ", foundedDate=" + foundedDate + ", ceo=" + ceo + "]";
	}
	
}
