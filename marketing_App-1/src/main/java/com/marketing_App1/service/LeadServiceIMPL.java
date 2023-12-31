
package com.marketing_App1.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing_App1.dto.LeadDto;
import com.marketing_App1.entity.Lead;
import com.marketing_App1.repository.Leadrepository;

@Service
public class LeadServiceIMPL implements LeadService {

	@Autowired
	private Leadrepository Leadrepo;

	@Override
	public void saveLead(Lead lead) {

		Leadrepo.save(lead);
	}

	@Override
	public List<Lead> findAllLeads() {
		List<Lead> leads=Leadrepo.findAll();
		return leads;
	}

	@Override
	public void deleteLeadByid(long id) {
		// TODO Auto-generated method stub
		Leadrepo.deleteById(id);
		
	}

	@Override
	public void updateLeadByid(long id) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public Lead findLeadByid(long id) {
		// TODO Auto-generated method stub
		return Leadrepo.findById(id).get();
		
	}

	@Override
	public void updateLead(LeadDto dto) {
		// TODO Auto-generated method stub
		Lead lead=new Lead();
		lead.setId(dto.getId());
		lead.setFirstName(dto.getFirstName());
		lead.setLastName(dto.getLastName());
		lead.setEmail(dto.getEmail());
		lead.setMobile(dto.getMobile());
		Leadrepo.save(lead);
		
	}

	

}
