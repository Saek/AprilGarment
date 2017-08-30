package com.testspring.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddDataController {
	
	@RequestMapping(value="/addFactory")
	public String addFactory() {
		return "addFactory";
	}
	
	@RequestMapping(value="/addCloth")
	public String addCloth() {
		return "addCloth";
	}
}
