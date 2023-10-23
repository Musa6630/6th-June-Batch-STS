package com.marketing_App1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing_App1.dto.LeadDto;
import com.marketing_App1.entity.Lead;
import com.marketing_App1.service.LeadService;



@Controller
public class Lead_Controller {

	@RequestMapping("/viewLeadForm")
	public String viewLeadForm() {
		return "create_lead";
	}

	@Autowired
	private LeadService leadService;
	// http://localhost:8080/viewLeadForm

	
	@RequestMapping("/saveLead")
	public String saveLeadInfo(@ModelAttribute Lead lead, ModelMap model) {
		model.addAttribute("msg", "Record is saved");
		leadService.saveLead(lead);
		return "create lead"; // return null;

	}
	 

//	@RequestMapping("/saveLead")
//	public String saveLeadInfo(
//			@RequestParam("firstName") String firstName,
//			@RequestParam("lastName") String LastName,
//			@RequestParam("mobile") long mobile,
//			@RequestParam("Email") String EmailId
//			) 
//	{
//		Lead l=new Lead();
//		l.setFirstName(firstName);
//		l.setLastName(LastName);
//		l.setMobile(mobile);
//		l.setEmail(EmailId);
//		leadService.saveLead(l);
//		return "Create Lead";
//	}
//	

//	@RequestMapping("/saveLead")
//	public String saveLeadInfo(LeadDto dto) {
//		
//		Lead lead=new Lead();
//		lead.setFirstName(dto.getFirstName());
//		lead.setLastName(dto.getLastName());
//		lead.setEmail(dto.getEmail());
//		lead.setMobile(dto.getMobile());
//		leadService.saveLead(lead);
//		return "create lead"; // return null;
//
//	}
	//http://localhost:8080/listall
	@RequestMapping("listall")
	public String getAllLeads(Model model) {
		List<Lead>  leads= leadService.findAllLeads();
//		System.out.println(leads);
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	
	@RequestMapping("/delete")
	public String deleteLeadByid(@RequestParam("id") long id, Model model) {
		leadService.deleteLeadByid(id);
		List<Lead>  leads= leadService.findAllLeads();
//		System.out.println(leads);
		model.addAttribute("leads", leads);
		return "list_leads";
		
	}
	
	@RequestMapping("/update")
	public String updateLeadByid(@RequestParam("id") long id, Model model) {
		Lead lead = leadService.findLeadByid(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}

}
