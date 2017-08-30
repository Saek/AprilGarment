package com.testspring.apicontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.testspring.jsonview.Views;
import com.testspring.models.Cloth;
//import com.testspring.models.Greeting;
import com.testspring.models.ajaxResponse.ClothDetail;
import com.testspring.services.ClothService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class ViewDatasAjaxController {
	@Autowired
	private ClothService clothService;
	
	public void setProductService(ClothService clothService) {
		this.clothService = clothService;
	}
	
	@JsonView(Views.Public.class)
	@RequestMapping(value="/api/getClothById", method= RequestMethod.GET)
	public ClothDetail getClothById(@RequestParam(value="clothId") int clothId) {
		System.out.println("#S getClothById: " + clothId);
		ClothDetail clothDetail = this.clothService.getClothDetailById(clothId);
		return clothDetail;
	}
	
//	@JsonView(Views.Public.class)
//	@RequestMapping(value="/api/letTest")
//	public Greeting letTest(@RequestBody Greeting greeting) {
//		System.out.println("#S greeting: " + greeting);
//		greeting.setId(111);
//		greeting.setMessage("response back");
//		return greeting;
//	}
}
