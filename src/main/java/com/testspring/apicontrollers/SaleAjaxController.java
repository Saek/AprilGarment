package com.testspring.apicontrollers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testspring.jsonview.Views;
import com.testspring.models.Cloth;
import com.testspring.models.Sale;
import com.testspring.models.ajaxRequest.SaleForm;
import com.testspring.models.ajaxResponse.ClothDetail;
import com.testspring.models.ajaxResponse.ClothDropDownList;
import com.testspring.models.ajaxResponse.CommonResponse;
import com.testspring.services.SaleService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class SaleAjaxController {
	
	@Autowired
	private SaleService saleService;
	
	public void setSaleService(SaleService saleService) {
		this.saleService = saleService;
	}
	
	@JsonView(Views.Public.class)
	@RequestMapping(value="/api/sellProducts")
	public CommonResponse sellProducts(@RequestBody SaleForm saleForm) {
	// SaleForm
	//	public CommonResponse sellProducts(@RequestParam("test") String test) {
		List<Sale> saleList = this.saleService.getSaleList();
		this.saleService.sellProducts(saleForm);
		CommonResponse response = new CommonResponse();
		response.setMessage("#S Sell Success!!");
		return response;
	}
	
	@JsonView(Views.Public.class)
	@RequestMapping(value="/api/getClothInSalePage")
	public ClothDetail getClothInSalePage(@RequestBody int id) {
		System.out.println("#S id in SaleAjaxController");
		
		ClothDetail clothDetail = new ClothDetail();
		Cloth cloth = saleService.getClothInSalePage(id);
		clothDetail.setClothId(cloth.getClothId());
		clothDetail.setPrice(cloth.getPrice());
		clothDetail.setAvailableAmount(cloth.getAvailableAmount());
		return clothDetail;
	}
	
	@JsonView(Views.Public.class)
	@RequestMapping(value="/api/getClothModelByStoreId")
	public List<ClothDropDownList> getClothModelByStoreId(@RequestParam("storeId") int storeId) {
		System.out.println("#S id in SaleAjaxController");
		List<ClothDropDownList> clothDropDownList = saleService.getClothesMap(storeId);
		saleService.getClothInSalePage(1);

		return clothDropDownList;
	}
}
