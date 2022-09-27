package com.emp.project.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.emp.project.api.entity.Compliance;
import com.emp.project.api.repo.ComplianceRepo;
import com.emp.project.api.service.ComplianceService;

public class ComplianceServiceImpl implements ComplianceService {
@Autowired
	ComplianceRepo complianceRepo;
	@Override
	public int addComplain(Compliance compliance) {
this.complianceRepo.save(compliance);
		return 1;
	}

}
