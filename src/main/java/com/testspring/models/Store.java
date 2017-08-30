package com.testspring.models;

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
@Table(name="Store")
public class Store {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="store_id")
	private int storeId;
	@Column(name="store_name")
	private String storeName;
	@Column(name="store_branch")
	private String storeBranch;
	@Column(name="store_group")
	private String storeGroup;
	@Column(name="house_no")
	private String houseNo;
	@Column(name="village_no")
	private String villageNo;
	@Column(name="alley")
	private String alley;
	@Column(name="lane")
	private String lane;
	@Column(name="road")
	private String road;
	@Column(name="sub_district")
	private String subDistrict;
	@Column(name="district")
	private String district;
	@Column(name="province")
	private String province;
	@Column(name="postal_code")
	private String postalCode;
	@Column(name="country")
	private String country;
	@Column(name="contact")
	private String contact;
	@Column(name="region")
	private String region;
	
	@OneToMany(mappedBy="store")
	private Set<ClothAndStore> clothAndStore = new HashSet<ClothAndStore>();
	
	public Set<ClothAndStore> getClothAndStore() {
		return clothAndStore;
	}
	public void setClothAndStore(Set<ClothAndStore> clothAndStore) {
		this.clothAndStore = clothAndStore;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreBranch() {
		return storeBranch;
	}
	public void setStoreBranch(String storeBranch) {
		this.storeBranch = storeBranch;
	}
	public String getStoreGroup() {
		return storeGroup;
	}
	public void setStoreGroup(String storeGroup) {
		this.storeGroup = storeGroup;
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
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
}
