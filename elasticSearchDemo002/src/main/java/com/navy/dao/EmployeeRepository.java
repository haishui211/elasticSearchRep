package com.navy.dao;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.navy.entity.Employee;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String>{
	Employee findByName(String name);
}
