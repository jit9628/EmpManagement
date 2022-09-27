package com.emp.project.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.project.api.entity.Department;
import com.emp.project.api.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	 User findById(String string);
	// public User findByuserName(String user);
	 
}
