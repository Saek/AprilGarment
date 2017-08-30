package com.testspring.webcontrollers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.testspring.services.ProductService;
import com.testspring.services.StoreService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping(value="/addProduct")
	public String showProductPage(Model model) {
		Map<Integer, String> factoriesMap = productService.getFactoriesMap();
		Map<Integer, String> clothesMap = productService.getClothesMap();
//		productService.get
		model.addAttribute("factoriesMap", factoriesMap);
		model.addAttribute("clothesMap", clothesMap);
		return "productPage";
	}
	
	@RequestMapping(value="/sendProduct")
	public String showSendProductPage(Model model) {
		Map<Integer, String> storesMap = productService.getStoresMap();
		Map<Integer, String> clothesMap = productService.getClothesMap();
//		productService.get
		model.addAttribute("storesMap", storesMap);
		model.addAttribute("clothesMap", clothesMap);
		return "sendProductPage";
	}
}
