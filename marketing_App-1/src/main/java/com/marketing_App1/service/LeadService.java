package com.marketing_App1.service;

import java.util.List;

import com.marketing_App1.dto.LeadDto;
import com.marketing_App1.entity.Lead;

public interface LeadService {

	public void saveLead(Lead lead);

	public List<Lead> findAllLeads();

	public void deleteLeadByid(long id);

	public void updateLeadByid(long id);

	public Lead findLeadByid(long id);

	public void updateLead(LeadDto dto);

	
}
