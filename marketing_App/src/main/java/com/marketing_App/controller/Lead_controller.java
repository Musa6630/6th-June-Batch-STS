package com.marketing_App.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lead_controller {
	

	@RequestMapping("/viewLeadForm")
	public String viewLeadForm() {
		return "create_lead";
	}
}
