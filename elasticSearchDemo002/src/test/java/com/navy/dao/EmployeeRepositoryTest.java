package com.navy.dao;

import java.util.List;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MoreLikeThisQueryBuilder.Item;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import com.navy.entity.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void testSave() {
		for(int i = 0; i < 100; i++) {
			Employee employee = new Employee();
			employee.setId(i+"");
			employee.setName("haishui"+i);
			this.employeeRepository.save(employee);
		}
	}
	
	@Test
	public void testFindByName() {
		String name = "haishui";
		Employee employee = this.employeeRepository.findByName(name);
		System.out.println(employee);
	}
	
	@Test
	public void testSearch() {
		String name = "haishui";
		Employee employee = this.employeeRepository.findByName(name);
		System.out.println(employee);
	}
	
	@Test
	public void testSearch002() {
		Pageable page = PageRequest.of(0, 10);
		BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
		queryBuilder.must(QueryBuilders.matchQuery("name", "haishui"));
		SearchQuery query = new NativeSearchQueryBuilder().withQuery(queryBuilder).withPageable(page).build();
		Page<Employee> pages = this.employeeRepository.search(query);
		List<Employee> list = pages.getContent();
		System.out.println(list);
	}
	
	@Test
	public void testSearch003() {
		Pageable page = PageRequest.of(0, 10);
		BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
		queryBuilder.must(QueryBuilders.fuzzyQuery("name", "haishui"));
		SearchQuery query = new NativeSearchQueryBuilder().withQuery(queryBuilder).withPageable(page).build();
		Page<Employee> pages = this.employeeRepository.search(query);
		List<Employee> list = pages.getContent();
		System.out.println(list);
	}
}
