package com.testspring.webcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.testspring.models.Cloth;
import com.testspring.models.Factory;
import com.testspring.services.ClothService;
import com.testspring.services.FactoryService;


@Controller
public class ViewDatasController {

	@Autowired
	private ClothService clothService;
	
	@Autowired
	private FactoryService factoryService;
	
	public void setClothService(ClothService clothService){
		this.clothService = clothService;
	}
	
	public void setFactoryService(FactoryService factoryService){
		this.factoryService = factoryService;
	}
	
	@RequestMapping(value={"/","/viewData"})
	public String viewClothes() {
		System.out.println("#S viewClothes()");
		List<Cloth> clothList = clothService.showClothes();
		System.out.println("#S clothList is: " + clothList);
		
//		List<Factory> factoryList = this.factoryService.showFactories();
//		System.out.println("#S factoryList: " + factoryList);
		
		return "viewData";
	}
	
	@RequestMapping(value="/viewClothTab")
	public String viewClothTab(Model model) {
		System.out.println("#S viewClothTab()");
		List<Cloth> clothList = clothService.showClothes();
		model.addAttribute("clothList", clothList);
		return "/tabs/viewdata/clothTab";
	}
	
	@RequestMapping(value="/viewFactoryTab")
	public String viewFactoryTab() {
		System.out.println("#S viewFactoryTab()");

		return "/tabs/viewdata/factoryTab";
	}
	
	@RequestMapping(value="/viewSaleTab")
	public String viewSaleTab() {
		System.out.println("#S viewSaleTab()");

		return "/tabs/viewdata/saleTab";
	}
	
	@RequestMapping(value="/viewStoreTab")
	public String viewStoreTab() {
		System.out.println("#S viewStoreTab()");

		return "/tabs/viewdata/storeTab";
	}
	
	@RequestMapping(value="/viewClothDetail")
	public String viewClothDetail() {
		System.out.println("#S viewStoreTab()");
		
		return "/modals/viewdata/viewClothDetailModal";
	}
}
