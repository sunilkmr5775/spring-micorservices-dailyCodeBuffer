package com.dailycodebuffer.user.service;

import com.dailycodebuffer.user.VO.Department;
import com.dailycodebuffer.user.VO.ResponseTemplateVO;
import com.dailycodebuffer.user.entity.User;
import com.dailycodebuffer.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
    	LOGGER.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
    	LOGGER.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
System.out.println("user id==="+user.getDepartmentId());
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),Department.class);
//        Department department =   restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(),Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return  vo;
    }
}
