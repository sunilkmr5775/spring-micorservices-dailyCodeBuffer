package com.dailycodebuffer.department.service;

import com.dailycodebuffer.department.entity.Department;
import com.dailycodebuffer.department.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);
	
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
    	LOGGER.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        LOGGER.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
