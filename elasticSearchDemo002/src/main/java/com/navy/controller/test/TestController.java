package com.navy.controller.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navy.dao.EmployeeRepository;
import com.navy.entity.Employee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="test接口")
@RestController
@RequestMapping("/test/")
public class TestController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@ApiOperation(value="新增操作")
	@PostMapping("save")
	public Object save(@RequestBody Employee employee) {
		try {
			return employeeRepository.save(employee);
		}
		catch(Exception e) {
			return e;
		}
	}
	
	@PostMapping("get")
	public Object get(@RequestBody Employee employee) {
		try {
			return this.employeeRepository.findById(employee.getId());
		}
		catch(Exception e) {
			return e;
		}
	}
	
	@PostMapping("delete")
	public Object delete(@RequestBody Employee employee) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			this.employeeRepository.delete(employee);
			map.put("result", "deleteOk.");
			map.put("id", employee.getId());
			return map;
		}
		catch(Exception e) {
			return e;
		}
	}
	
	@PostMapping("search")
	public Object search(@RequestBody Employee employee) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			this.employeeRepository.delete(employee);
			map.put("result", "deleteOk.");
			map.put("id", employee.getId());
			return map;
		}
		catch(Exception e) {
			return e;
		}
	}
}
