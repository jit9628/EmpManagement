package com.emp.project.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.project.api.entity.Department;
@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer>{
 public Department findBydept(String department);
}
