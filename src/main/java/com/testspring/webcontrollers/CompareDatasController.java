package com.testspring.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompareDatasController {
	
	@RequestMapping(value="/compareDatas")
	public String showComparePage() {
		return "comparePage";
	}
}
