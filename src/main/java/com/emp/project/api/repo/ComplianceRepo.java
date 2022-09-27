package com.emp.project.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.project.api.entity.Compliance;

@Repository
public interface ComplianceRepo extends JpaRepository<Compliance, Integer>{

}
