package com.testspring.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testspring.daos.ClothDAO;
import com.testspring.models.Cloth;
import com.testspring.models.ajaxResponse.ClothDetail;

@Service
public class ClothServiceImpl implements ClothService{

	private ClothDAO clothDAO;
	
	public void setClothDAO(ClothDAO clothDAO) {
		this.clothDAO = clothDAO;
	}
	
	@Transactional
	public List<Cloth> showClothes() {
		return this.clothDAO.showClothes();
	}

	@Transactional
	public Cloth getClothById(int id) {
		return this.clothDAO.getClothById(id);
	}

	@Transactional
	public ClothDetail getClothDetailById(int id) {
		Cloth cloth = this.clothDAO.getClothById(id);
		
		ClothDetail clothDetail = new ClothDetail(); 
		clothDetail.setClothId(cloth.getClothId());
		clothDetail.setClothGroup(cloth.getClothGroup());
		clothDetail.setClothType(cloth.getClothType());
		clothDetail.setMadeByYear(cloth.getMadeByYear());
		clothDetail.setColor(cloth.getColor());
		clothDetail.setModel(cloth.getModel());
		clothDetail.setPrice(cloth.getPrice());
		clothDetail.setSize(cloth.getSize());
		clothDetail.setActive(cloth.getActive());
		clothDetail.setClothBrand(cloth.getClothBrand());
		return clothDetail;
	}

}
