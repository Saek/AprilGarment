package com.testspring.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testspring.daos.ClothDAO;
import com.testspring.models.Cloth;

@Service
public class CompareDataServiceImpl implements CompareDataService {

	private ClothDAO clothDAO;
	
	public void setClothDAO(ClothDAO clothDAO) {
		this.clothDAO = clothDAO;
	}
	
	@Transactional
	public Map<Integer, String> getClothesMap() {
		System.out.println("#S getClothList");
		List<Cloth> clothList = clothDAO.getClothesForDropDownList();
		
		Map<Integer, String> clothDropDownList = new HashMap<Integer, String>();
		for(Object obj : clothList) {
			Object[] objs = (Object[]) obj;
			Integer clothId = (Integer) objs[0];
			String model = (String) objs[1];
			System.out.println("#S clothId(): " + clothId);
			System.out.println("#S model: " + model);
			clothDropDownList.put(clothId, model);
		}
		System.out.println("#S compDropDownList: " + clothDropDownList);
		return clothDropDownList;
	}
}
