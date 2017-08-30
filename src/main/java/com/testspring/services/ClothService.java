package com.testspring.services;

import java.util.List;
import com.testspring.models.Cloth;
import com.testspring.models.ajaxResponse.ClothDetail;

public interface ClothService {
	
	public List<Cloth> showClothes();
	public Cloth getClothById(int id);
	public ClothDetail getClothDetailById(int id);
	
}
