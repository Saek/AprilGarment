package com.testspring.apicontrollers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.testspring.jsonview.Views;
import com.testspring.models.Cloth;
import com.testspring.models.ajaxRequest.ProductForm;
import com.testspring.models.ajaxRequest.SendProductForm;
import com.testspring.models.ajaxResponse.ClothDetail;
import com.testspring.services.ProductService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class ProductAjaxController {
	
	@Autowired
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@JsonView(Views.Public.class)
	@RequestMapping(value="/api/getClothPrice")
//	public int getClothPrice(@RequestBody int id) {
	public BigDecimal getClothPrice(@RequestBody int id) {
		System.out.println("#S id in ProductAjaxController");
		BigDecimal price = productService.getPriceByClothId(id);
		return price;
	}
	
	@JsonView(Views.Public.class)
	@RequestMapping(value="/api/addProducts")
	public int addProductsAjax(@RequestBody ProductForm productForm) {
		System.out.println("#S id in addProductsAjax");
		productService.addProduct(productForm);
		return 0;
	}
	
	@JsonView(Views.Public.class)
	@RequestMapping(value="/api/getClothInSendProductPage")
	public ClothDetail getClothInSendProductPage(@RequestBody int id) {
		System.out.println("#S id in SaleAjaxController");
		
		ClothDetail clothDetail = new ClothDetail();
		Cloth cloth = productService.getClothInSendProductPage(id);
        clothDetail.setClothId(cloth.getClothId());
		clothDetail.setPrice(cloth.getPrice());
		clothDetail.setAvailableAmount(cloth.getAvailableAmount());
		return clothDetail;
	}
	
	@JsonView(Views.Public.class)
	@RequestMapping(value="/api/sendProduct")
	public ClothDetail sendProduct(@RequestBody SendProductForm sendProductForm) {
		System.out.println("#S id in SaleAjaxController");
		
		int clothId = sendProductForm.getClothId();
		int storeId = sendProductForm.getStoreId();
		int amount = sendProductForm.getSendAmount();
		productService.saveClothAndStore(clothId, storeId, amount);
		return null;
	}
}
