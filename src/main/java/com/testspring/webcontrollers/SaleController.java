package com.testspring.webcontrollers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.testspring.models.Sale;
import com.testspring.models.Store;
import com.testspring.services.ClothService;
import com.testspring.services.SaleService;
import com.testspring.services.StoreService;

@Controller
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	public void setSaleService(SaleService saleService) {
		this.saleService = saleService;
	}
	
	@RequestMapping(value="/sale")
	public String showSalePage(Model model) {
		Map<Integer, String> storesMap = saleService.getStoresMap();
		model.addAttribute("storesMap", storesMap);
//		Map<Integer, String> clothesMap = saleService.getClothesMap();
//		model.addAttribute("clothesMap", clothesMap);

		return "salePage";
	}

}
